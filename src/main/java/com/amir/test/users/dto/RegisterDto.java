package com.amir.test.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    @NotBlank
    @Email
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    private String name;

    @NotBlank
    private String family;

    private Set<String> roles;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

}
