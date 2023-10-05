package com.RestAPIdb.RestApiDB.mapper;

import com.RestAPIdb.RestApiDB.dto.UserDto;
import com.RestAPIdb.RestApiDB.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user)
    {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getDiabet(),
                user.getAge()
        );
        return userDto;

    }

    public static User mapToUser(UserDto userDto)
    {
        User user = new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getDiabet(),
                userDto.getAge()
        );
        return  user;
    }
}
