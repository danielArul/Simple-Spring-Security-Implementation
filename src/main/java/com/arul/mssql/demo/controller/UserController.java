package com.arul.mssql.demo.controller;

import com.arul.mssql.demo.dao.UserRepo;
import com.arul.mssql.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        System.out.println(user);
        user.setPassword(encoder.encode(user.getPassword()));
        User userObj= userRepo.save(user);
        return new ResponseEntity<>(userObj, HttpStatus.OK);
    }

}
