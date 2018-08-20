package com.catalyte.dealership.Services;

import com.catalyte.dealership.Models.User;
import com.catalyte.dealership.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface{
    @Autowired
    UserRepository userRepository;


    public boolean create(User user) {
        try {
            userRepository.insert(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public boolean update(User user) {
        try {
            userRepository.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean delete(String id) {
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
