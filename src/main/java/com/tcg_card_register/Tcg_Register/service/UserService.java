package com.tcg_card_register.Tcg_Register.service;

import com.tcg_card_register.Tcg_Register.interfaces.UserRepository;
import com.tcg_card_register.Tcg_Register.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public UserModel updateUser(UserModel user);

    public UserModel deleteUser(Long id);

    public List<UserModel> getAllUsers();

    public UserModel findUserById(Long id);

    public UserModel createUser(UserModel user);
}
