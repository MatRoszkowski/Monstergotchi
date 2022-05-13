package com.mateuszroszkowski.Monstergotchi.service.implementation;

import com.mateuszroszkowski.Monstergotchi.model.User;
import com.mateuszroszkowski.Monstergotchi.repository.UserRepository;
import com.mateuszroszkowski.Monstergotchi.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createUser(User user) {
        Optional<User> userOptional = userRepository.findUserByUsername(user.getUsername());
        if (userOptional.isPresent()) {
            throw new RuntimeException("User with username: " + user.getUsername() + " already exists");
        } else userRepository.insert(user);
        log.info("User saved successfully");
    }
}
