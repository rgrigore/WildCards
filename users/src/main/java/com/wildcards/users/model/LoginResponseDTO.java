package com.wildcards.users.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class LoginResponseDTO {
    private Long id;
    private String email;
    private String username;
}
