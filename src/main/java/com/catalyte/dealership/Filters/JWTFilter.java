package com.catalyte.dealership.Filters;

import com.catalyte.dealership.Services.TokenService;
import com.catalyte.dealership.Services.TokenServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class JWTFilter extends GenericFilterBean {
    private TokenService tokenService;

    JWTFilter() {
        this.tokenService = new TokenServiceImpl();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
        throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;

        String token = request.getHeader("AuthToken");

        // Check if request is type OPTIONS, if it is let it through
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.sendError(HttpServletResponse.SC_OK, "success");
            return;
        }

        // Check if request path exists in list of paths where token is not required
        if (allowRequestWithoutToken(request)) {
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(req, res);
        } else {
            // Check if token is either null or invalid, if it is, send a response error
            // saying that user is not authorized to access this non-whitelisted resource
            if (token == null || !tokenService.isTokenValid(token)) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "This is a protected resource that requires a valid JSON Web Token to access");
            } else {
                // If the token is valid, fetch the user id from the token and append
                // it to the request's attributes and let the remaining filter chain execute
                String userId = new String(tokenService.getUserIdFromToken(token));
                request.setAttribute("userId", userId);
                filterChain.doFilter(req, res);
            }
        }
    }

    private boolean allowRequestWithoutToken(HttpServletRequest request){
        List<String> whitelist = new ArrayList();
        //TODO: Add whitelisted paths to `whitelist`
        return whitelist.contains(request.getRequestURI());
    }
}
