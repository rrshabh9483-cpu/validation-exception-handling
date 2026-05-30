package com.lcwr.validation_exception_handling.validation_exception_handling.controller;

import com.lcwr.validation_exception_handling.validation_exception_handling.dto.UserRequest;
import com.lcwr.validation_exception_handling.validation_exception_handling.entity.User;
import com.lcwr.validation_exception_handling.validation_exception_handling.exception.UserNotFoundException;
import com.lcwr.validation_exception_handling.validation_exception_handling.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest) {
         return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/findUser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) throws  UserNotFoundException{
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
