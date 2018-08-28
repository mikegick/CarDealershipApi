package com.catalyte.dealership.Services;

public interface TokenService {
    String createToken(String userId);

    String getUserIdFromToken(String token);
}
