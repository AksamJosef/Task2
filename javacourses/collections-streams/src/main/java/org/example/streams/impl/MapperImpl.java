package org.example.streams.impl;

import org.example.streams.function.Mapper;
import org.example.streams.model.User;
import org.example.streams.model.UserDto;

public class MapperImpl implements Mapper<User, UserDto> {

    @Override
    public UserDto map(User user) {
        return UserDto.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .build();
    }
}
