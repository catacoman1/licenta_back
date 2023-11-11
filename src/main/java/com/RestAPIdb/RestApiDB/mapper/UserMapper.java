package com.RestAPIdb.RestApiDB.mapper;

import com.RestAPIdb.RestApiDB.dto.UserDto;
import com.RestAPIdb.RestApiDB.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user)
    {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirst_name(),
                user.getLast_name(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getDiabet(),
                user.getAge()
        );
        return userDto;

    }

    public static User mapToUser(UserDto userDto)
    {
        User user = new User(
                userDto.getId(),
                userDto.getFirst_name(),
                userDto.getLast_name(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getRole(),
                userDto.getDiabet(),
                userDto.getAge()
        );
        return  user;
    }
}
