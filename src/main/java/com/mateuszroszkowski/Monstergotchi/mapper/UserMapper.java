package com.mateuszroszkowski.Monstergotchi.mapper;

import com.mateuszroszkowski.Monstergotchi.dto.MonsterDto;
import com.mateuszroszkowski.Monstergotchi.dto.UserDto;
import com.mateuszroszkowski.Monstergotchi.model.Monster;
import com.mateuszroszkowski.Monstergotchi.model.User;

public class UserMapper {
    public User map(UserDto userDto) {
        return User.builder()
                .name(userDto.getName())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .build();

    }

    public UserDto map(User user) {
        return UserDto.builder()
                .name(user.getName())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
