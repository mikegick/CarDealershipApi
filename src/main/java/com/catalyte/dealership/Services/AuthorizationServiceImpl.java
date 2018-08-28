package com.catalyte.dealership.Services;

import com.catalyte.dealership.Models.User;
import com.catalyte.dealership.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    UserRepository userRepository;

    TokenService tokenService;

    public AuthorizationServiceImpl(){
        this(new TokenServiceImpl());
    }

    public AuthorizationServiceImpl(TokenService tokenService){
        this.tokenService = tokenService;
    }

    public String getJWT(String username, String password){
        try {
            // Validate that the individual is who they say they are
            User user = userRepository.getPasswordAndSaltByEmail(username).get(0);
            if (user != null && user.getPassword().equals(password)) {
                return tokenService.createToken(user.getEmail());
            }
            return null;
        }catch (Exception ex){
            //TODO: Log exception to log file
            return null;
        }
    }
}
