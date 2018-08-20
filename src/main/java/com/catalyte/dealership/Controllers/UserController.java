package com.catalyte.dealership.Controllers;


import com.catalyte.dealership.Models.User;
import com.catalyte.dealership.Services.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;
    UserController(UserService userService){this.userService=userService;}

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody User user){
        userService.create(user);
    }

    @RequestMapping(value= "/findAll", method =RequestMethod.GET)
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
