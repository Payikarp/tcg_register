package com.tcg_card_register.Tcg_Register.service.implementation;

import com.tcg_card_register.Tcg_Register.exceptions.DatabaseException;
import com.tcg_card_register.Tcg_Register.exceptions.ResourceNotFoundException;
import com.tcg_card_register.Tcg_Register.interfaces.UserRepository;
import com.tcg_card_register.Tcg_Register.models.UserModel;
import com.tcg_card_register.Tcg_Register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepository;

    public UserModel updateUser(UserModel user)
    {
        UserModel existingUser = userRepository.findById(user.getId()).orElseThrow(() -> new ResourceNotFoundException("User not found."));
        try
        {
            return userRepository.save(user);
        }catch (Exception exception)
        {
            throw new DatabaseException("Error saving to the database: "+ exception.getMessage());
        }
    }

    @Override
    public UserModel deleteUser(Long id) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found."));
        user.setStatus(2);
        try
        {
            return userRepository.save(user);
        }catch (Exception exception)
        {
            throw new DatabaseException("Error saving to the database: "+ exception.getMessage());
        }


    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserModel findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found."));
    }

    @Override
    public UserModel createUser(UserModel user) {
        try
        {
            return userRepository.save(user);
        }catch (Exception exception)
        {
            throw new DatabaseException("Error saving to the database: "+ exception.getMessage());
        }
    }
}
