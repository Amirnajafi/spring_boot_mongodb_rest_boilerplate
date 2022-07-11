package com.amir.test.users.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUsersDto {
    private String id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String family;
    @NotEmpty @Email
    private String username;
}
