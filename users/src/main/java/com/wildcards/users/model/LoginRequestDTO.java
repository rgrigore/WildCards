package com.wildcards.users.model;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String email;
    private String password;
}
