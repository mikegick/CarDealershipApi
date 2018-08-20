package com.catalyte.dealership.Controllers;


import com.catalyte.dealership.Models.User;
import com.catalyte.dealership.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    public UserController(){
        this(new UserServiceImpl());
    }

    UserController(UserService userServiceImpl){
        this.userService = userServiceImpl;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody User user){
        userService.create(user);
    }

    @RequestMapping(value= "/retrieve", method =RequestMethod.GET)
    public List<User>findAll(){
        return userService.findAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody User user){
        userService.update(user);
    }

    @RequestMapping(value ="/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody String id){
        userService.delete(id);
    }
}
