package com.amir.test.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String token;
    private String type = "Bearer";
    private String id;
    private String username;
    private String name;
    private String family;

    public LoginResponse(String accessToken, String id, String username, String name , String family) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.name = name;
        this.family = family;
    }
}
