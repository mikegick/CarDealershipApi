package com.catalyte.dealership.Controllers;


import com.catalyte.dealership.CustomExceptions.InvalidUsernamePasswordException;
import com.catalyte.dealership.CustomExceptions.NotAuthorizedException;
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

    @Autowired
    AuthorizationService authService;

    public UserController(){
        this(new UserServiceImpl(), new AuthorizationServiceImpl());
    }

    UserController(UserService userService, AuthorizationService authService){
        this.userService = userService;
        this.authService = authService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody User user){
        userService.create(user);
    }

    @RequestMapping(value= "/retrieve", method = RequestMethod.GET)
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

    @RequestMapping(value = "/getToken", method = RequestMethod.GET)
    public String getToken(@RequestBody String username, @RequestBody String password){
        String token = authService.getJWT(username, password);
        if(token == null){
            throw new InvalidUsernamePasswordException();
        } else {
            return token;
        }
    }
}
