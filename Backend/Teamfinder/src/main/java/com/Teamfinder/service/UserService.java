package com.Teamfinder.service;

import com.Teamfinder.controller.dto.AfterLoginDto;
import com.Teamfinder.controller.dto.LoginDto;
import com.Teamfinder.entity.User;

import java.util.UUID;

public interface UserService {

    Long createNewUser(User user);

    User getUserById(Long userId);

    void deleteUserById(Long userId);

    void updateUserInfo(Long userId, User user);

    AfterLoginDto loginUser(LoginDto loginDto);

    boolean isUserAdmin(Long userId);
}
