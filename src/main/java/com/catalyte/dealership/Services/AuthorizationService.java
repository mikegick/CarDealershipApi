package com.catalyte.dealership.Services;

public interface AuthorizationService {
    String getJWT(String username, String password);
}
