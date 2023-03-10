package com.Teamfinder.service.impl;

import com.Teamfinder.controller.dto.AfterLoginDto;
import com.Teamfinder.controller.dto.LoginDto;
import com.Teamfinder.entity.User;
import com.Teamfinder.repository.UserRepository;
import com.Teamfinder.service.UserService;
import com.Teamfinder.service.exceptions.InvalidPasswordException;
import com.Teamfinder.service.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public static final String ID_DOES_NOT_EXIST = "User with this ID does not exist";
    public static final String LOGIN_DOES_NOT_EXIST = "User with this login does not exist";
    public static final String LOGIN_ALREADY_EXISTS = "User with this login already exists";
    public static final String INVALID_PASSWORD = "Wrong password for this login";

    @Override
    public Long createNewUser(User user) {
        checkUserWithIncomingLoginExists(user);
        return userRepository.save(User.builder().
                login(user.getLogin()).
                id(user.getId()).
                password(user.getPassword()).
                role(user.getRole()).
                build()).
                getId();
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isEmpty()) {
            throw new UserNotFoundException(ID_DOES_NOT_EXIST);
        }

        return userOptional.get();
    }

    @Override
    public void deleteUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isEmpty()) {
            throw new UserNotFoundException(ID_DOES_NOT_EXIST);
        }

        userRepository.deleteById(userId);
    }

    @Override
    public void updateUserInfo(Long userId, User user) {
        Optional<User> userOptional1 = userRepository.findById(userId);

        if(userOptional1.isEmpty()) {
            throw new UserNotFoundException(ID_DOES_NOT_EXIST);
        }

        checkUserWithIncomingLoginExists(user);

        user.setId(userId);
        userRepository.save(user);
    }

    @Override
    public AfterLoginDto loginUser(LoginDto loginDto) {

        User user = userRepository.findByLogin(loginDto.getLogin()).orElseThrow(
                () -> new UserNotFoundException(LOGIN_DOES_NOT_EXIST));

        if(!loginDto.getPassword().equals(user.getPassword())) {
            throw new InvalidPasswordException(INVALID_PASSWORD);
        }

        AfterLoginDto afterLoginDto = new AfterLoginDto();
        afterLoginDto.setId(user.getId());
        afterLoginDto.setAdmin(user.isAdmin());
        return afterLoginDto;
    }

    @Override
    public boolean isUserAdmin(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with this ID does not exist"));
        return user.isAdmin();
    }

    private void checkUserWithIncomingLoginExists(User user) {
        Optional<User> userOptional = userRepository.findByLogin(user.getLogin());

        if(userOptional.isPresent()) {
            throw new UserNotFoundException(LOGIN_ALREADY_EXISTS);
        }
    }
}