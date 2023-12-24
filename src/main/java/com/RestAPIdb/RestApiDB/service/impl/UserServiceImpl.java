package com.RestAPIdb.RestApiDB.service.impl;

import com.RestAPIdb.RestApiDB.dto.UserDto;
import com.RestAPIdb.RestApiDB.entity.User;
import com.RestAPIdb.RestApiDB.exception.userException.userNotFoundException;
import com.RestAPIdb.RestApiDB.exception.userException.userNotFoundExceptionByEmail;
import com.RestAPIdb.RestApiDB.mapper.UserMapper;
import com.RestAPIdb.RestApiDB.repository.UserRepository;
import com.RestAPIdb.RestApiDB.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService
{

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto)
    {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);

        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId)
    {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new userNotFoundException("user", "id", userId)
        );
        return UserMapper.mapToUserDto(user);

    }

    @Override
    public List<UserDto>  getAllUsers(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto)
    {
        User existingUser = userRepository.findById(userDto.getId()).get();

        existingUser.setFirst_name(userDto.getFirst_name());
        existingUser.setLast_name(userDto.getLast_name());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setPassword(userDto.getPassword());
        existingUser.setRole(userDto.getRole());
        existingUser.setDiabet(userDto.getDiabet());
        existingUser.setAge(userDto.getAge());
        User updatedUser = userRepository.save(existingUser);
        return UserMapper.mapToUserDto(updatedUser);
    }
    @Override
    public void deleteUser(Long userId)
    {
        userRepository.deleteById(userId);
    }

    @Override
    public String getUserEmailById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return user.getEmail();
        }
        return null;
    }

    @Override
    public UserDto getUserByEmail(String userEmail)
    {
        User user = userRepository.findByEmail(userEmail).orElseThrow(
                () -> new userNotFoundExceptionByEmail(userEmail)
        );
        return UserMapper.mapToUserDto(user);

    }

}
