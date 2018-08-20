package com.catalyte.dealership.Services;

import com.catalyte.dealership.Models.User;

import java.util.List;

public interface UserServiceInterface {

    boolean create(User user);
    List<User>findAll();
    boolean update(User user);
    boolean delete(String id);
}
