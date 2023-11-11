package com.RestAPIdb.RestApiDB.auth;

import com.RestAPIdb.RestApiDB.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private Long age;
    private String diabet;
    private Role role;
}
