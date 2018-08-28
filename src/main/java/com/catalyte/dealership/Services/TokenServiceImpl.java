package com.catalyte.dealership.Services;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

import java.time.LocalDateTime;
import java.util.Date;

public class TokenServiceImpl implements TokenService {
    public static final String TOKEN_SECRET = "Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=";
    public static final long HOUR = 3600000;

    public String createToken(String userId) {
        try {
            Date now = new Date();
            Date expiration = new Date(now.getTime() + 1*HOUR);

            String jws = Jwts.builder()
                    .setIssuer("CarDealershipApi")
                    .setSubject(userId)
                    .setIssuedAt(now)
                    .setExpiration(expiration)
                    .signWith(
                            SignatureAlgorithm.HS256,
                            TextCodec.BASE64.decode(TOKEN_SECRET)
                    )
                    .compact();

            return jws;
        } catch (Exception ex) {
            //TODO: Log exception to log file
            return null;
        }
    }

    public String getUserIdFromToken(String token) {
        try {
            Jws<Claims> jws = Jwts.parser()
                    .setSigningKey(TOKEN_SECRET)
                    .parseClaimsJws(token);

            return jws.getBody().getSubject();
        } catch(Exception ex) {
            //TODO: Log exception to log file
            return null;
        }
    }

    public boolean isTokenValid(String token) {
        String userId = this.getUserIdFromToken(token);
        return userId != null;
    }
}