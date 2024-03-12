package com.RestAPIdb.RestApiDB.controller;

import com.RestAPIdb.RestApiDB.dto.GlicemieDto;
import com.RestAPIdb.RestApiDB.dto.UserDto;
import com.RestAPIdb.RestApiDB.entity.Glicemie;
import com.RestAPIdb.RestApiDB.repository.GlicemieRepository;
import com.RestAPIdb.RestApiDB.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/**")
@AllArgsConstructor
@RequestMapping("api/users")
@SecurityRequirement(name="Bearer Authentication")
public class UserController {
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
    {
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id")Long userId)
    {
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers(UserDto userDto)
    {
        List<UserDto>users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,@RequestBody UserDto userDto)
    {
        userDto.setId(userId);
        UserDto updatedUser = userService.updateUser(userDto);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);

    }

    @DeleteMapping("id")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long userId)
    {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully!", HttpStatus.OK);
    }
    @GetMapping("{id}/email")
    public ResponseEntity<String> getUserEmail(@PathVariable("id") Long userId) {
        String userEmail = userService.getUserEmailById(userId);
        if (userEmail != null) {
            return new ResponseEntity<>(userEmail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable("email")String userEmail)
    {
        UserDto user = userService.getUserByEmail(userEmail);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/{id}/glicemie")
    public ResponseEntity<List<GlicemieDto>> getGlicemieByUserId(@PathVariable("id") Long userId)
    {
        List<GlicemieDto> glicemieDtoList = userService.getGlicemieByUserId(userId);
        return new ResponseEntity<>(glicemieDtoList, HttpStatus.OK);
    }

    @PostMapping("/{userId}/glicemie")
    public ResponseEntity<GlicemieDto> createGlicemie(@PathVariable("userId") Long userId, @RequestBody GlicemieDto glicemieDto) {
        GlicemieDto savedGlicemie = userService.createGlicemieForUser(userId, glicemieDto);
        return new ResponseEntity<>(savedGlicemie, HttpStatus.CREATED);
    }

}


