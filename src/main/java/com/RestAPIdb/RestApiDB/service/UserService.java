package com.RestAPIdb.RestApiDB.service;

import com.RestAPIdb.RestApiDB.dto.UserDto;
import com.RestAPIdb.RestApiDB.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long userId);
}
