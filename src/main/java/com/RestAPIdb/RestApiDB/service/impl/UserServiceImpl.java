package com.RestAPIdb.RestApiDB.service.impl;

import com.RestAPIdb.RestApiDB.dto.GlicemieDto;
import com.RestAPIdb.RestApiDB.dto.UserDto;
import com.RestAPIdb.RestApiDB.entity.Glicemie;
import com.RestAPIdb.RestApiDB.entity.User;
import com.RestAPIdb.RestApiDB.exception.userException.userNotFoundException;
import com.RestAPIdb.RestApiDB.exception.userException.userNotFoundExceptionByEmail;
import com.RestAPIdb.RestApiDB.mapper.UserMapper;
import com.RestAPIdb.RestApiDB.repository.GlicemieRepository;
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
    private GlicemieRepository glicemieRepository;

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
                () -> new userNotFoundException(userId));

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
    @Override
    public List<GlicemieDto> getGlicemieByUserId(Long userId)
    {
        List<Glicemie> glicemieList = glicemieRepository.findByUserId(userId);
        return glicemieList.stream()
                .map(glicemie -> new GlicemieDto(glicemie.getId(), glicemie.getValue(), glicemie.getDate()))
                .collect(Collectors.toList());
    }

    @Override
    public GlicemieDto createGlicemieForUser(Long userId, GlicemieDto glicemieDto)
    {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new userNotFoundException(userId));

        Glicemie glicemie = new Glicemie();
        glicemie.setValue(glicemieDto.getValue());
        glicemie.setDate(glicemieDto.getDate());
        glicemie.setUser(user);

        glicemie = glicemieRepository.save(glicemie);

        GlicemieDto savedGlicemieDto = new GlicemieDto();
        savedGlicemieDto.setId(glicemie.getId());
        savedGlicemieDto.setValue(glicemie.getValue());
        savedGlicemieDto.setDate(glicemie.getDate());

        return savedGlicemieDto;
    }

}
