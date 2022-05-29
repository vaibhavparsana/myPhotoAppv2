package com.example.myphotoappv2.resource;

import java.util.List;


import com.example.myphotoappv2.model.User;
import com.example.myphotoappv2.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User getUser() {
        return userService.getUser();
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
       return userService.saveUser(user);   
    }

    @GetMapping(value="/allUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public User getUserbyId(@PathVariable("userId") int userId){
        return userService.getUserById(userId);
    }

    @PutMapping("/user/{userId}")
    public User updateUser(@PathVariable("userId") int userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }
    

    @DeleteMapping("/user") 
    public User deleteUser(@RequestParam("userId") int userId){
        return userService.deleteUser(userId);
    }
    
}


