package com.tcg_card_register.Tcg_Register.service.implementation;

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
        return userRepository.save(user);
    }

    @Override
    public UserModel deleteUser(Long id) {
        UserModel user = userRepository.findById(id).orElse(null);
        if(user == null)
        {
            return null;
        }else
        {
            user.setStatus(2);
            return userRepository.save(user);
        }

    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserModel findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }
}
