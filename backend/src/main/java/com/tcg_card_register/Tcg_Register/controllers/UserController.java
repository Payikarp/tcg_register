package com.tcg_card_register.Tcg_Register.controllers;

import com.tcg_card_register.Tcg_Register.interfaces.UserRepository;
import com.tcg_card_register.Tcg_Register.models.UserModel;
import com.tcg_card_register.Tcg_Register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserModel> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Long id)
    {
        return userService.findUserById(id);
    }

    @GetMapping("/create")
    public UserModel registerUser(@RequestBody UserModel user) {return userService.createUser(user);}

    @PutMapping(value = "/update", consumes = "application/json")
    public UserModel updateUser(@RequestBody UserModel user)
    {
        return userService.updateUser(user);
    }

    @PutMapping("/delete/{id}")
    public UserModel deleteUser(@PathVariable Long id) {return userService.deleteUser(id);}


}

