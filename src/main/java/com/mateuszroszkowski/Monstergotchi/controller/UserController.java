package com.mateuszroszkowski.Monstergotchi.controller;

import com.mateuszroszkowski.Monstergotchi.dto.LoginDto;
import com.mateuszroszkowski.Monstergotchi.model.User;
import com.mateuszroszkowski.Monstergotchi.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public void register(@RequestBody User user) {
        try {
            userService.createUser(user);
        } catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginDto loginDto) {

    }
    @PostMapping("/logout")
    public void logout() {

    }

}
