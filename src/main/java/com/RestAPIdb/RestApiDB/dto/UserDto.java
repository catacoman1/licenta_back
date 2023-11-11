package com.RestAPIdb.RestApiDB.dto;

import com.RestAPIdb.RestApiDB.entity.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    private String first_name;

    private String last_name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String diabet;

    private Long age;

}
