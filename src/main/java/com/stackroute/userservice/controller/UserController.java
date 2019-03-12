package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User saveduser = userService.saveUser(user);
        return new ResponseEntity<User>(saveduser, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUsers(@RequestBody User user,@PathVariable int id) {
        user.setId(id);
        User updateUser  = userService.updateUser(user);
        return new ResponseEntity<User>(updateUser,HttpStatus.OK);

    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allusers = userService.getAllUser();
        return new ResponseEntity<>(allusers, HttpStatus.OK);

    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User userById = userService.getUserById(id);
        return new ResponseEntity<User>(userById, HttpStatus.OK);
    }
}