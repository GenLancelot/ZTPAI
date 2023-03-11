package com.Teamfinder.controller;

import com.Teamfinder.controller.configuration.Converter;
import com.Teamfinder.controller.dto.AfterLoginDto;
import com.Teamfinder.controller.dto.LoginDto;
import com.Teamfinder.controller.dto.RoleDto;
import com.Teamfinder.controller.dto.UserDto;
import com.Teamfinder.entity.Role;
import com.Teamfinder.entity.User;
import com.Teamfinder.service.UserService;
import com.Teamfinder.service.exceptions.InvalidPasswordException;
import com.Teamfinder.service.exceptions.LoginAlreadyTakenException;
import com.Teamfinder.service.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/")
@Slf4j
class UserController {

    private final UserService userService;
    private final Converter converter;
    private static final String USER_LOGGED_IN_SUCCESSFULLY = "User logged in successfully";
    public static final String USER_CREATED_SUCCESSFULLY = "User created successfully";
    public static final String USER_RETRIEVED_SUCCESSFULLY = "User retrieved successfully";
    public static final String USER_INFO_UPDATED_SUCCESSFULLY = "User info updated successfully";
    public static final String USER_DELETED_SUCCESSFULLY = "User deleted successfully";

    public UserController(UserService userService, Converter converter) {
        this.userService = userService;
        this.converter = converter;
    }

    @PostMapping("/register")
    public ResponseEntity<Long> createNewUser(@RequestBody UserDto userDto) {
        Long newlyCreatedUserId;
        try {
            RoleDto roleDto = new RoleDto();
            roleDto.setId(1);
            roleDto.setName("user");
            User user = converter.convert(userDto, User.class);
            Role role = converter.convert(roleDto, Role.class);
            user.setRole(role);
            newlyCreatedUserId = userService.createNewUser(user);
        } catch(UserNotFoundException userNotFoundException) {
            log.error(userNotFoundException.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        log.info(USER_CREATED_SUCCESSFULLY);
        return new ResponseEntity<>(newlyCreatedUserId, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AfterLoginDto> loginUser(@RequestBody LoginDto loginDto) {
        AfterLoginDto afterLoginDto;
        try {
            afterLoginDto = userService.loginUser(loginDto);
        } catch(UserNotFoundException userNotFoundException) {
            log.error(userNotFoundException.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch(InvalidPasswordException invalidPasswordException) {
            log.error(invalidPasswordException.getMessage());
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        log.info(USER_LOGGED_IN_SUCCESSFULLY);

        return new ResponseEntity<>(afterLoginDto, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
        User user;
        try {
            user = userService.getUserById(userId);
        } catch(UserNotFoundException userNotFoundException) {
            log.error(userNotFoundException.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info(USER_RETRIEVED_SUCCESSFULLY);
        return new ResponseEntity<>(converter.convert(user, UserDto.class), HttpStatus.OK);
    }


    @GetMapping("/{userId}/role")
    public ResponseEntity<Boolean> getUserRole(@PathVariable Long userId) {
        boolean isAdmin;
        try {
            isAdmin = userService.isUserAdmin(userId);
        } catch (UserNotFoundException userNotFoundException) {
            log.error(userNotFoundException.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(isAdmin, HttpStatus.OK);
    }

}
