package com.amir.test.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

@Document(value = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Users {
    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    private String name;
    private String family;
    @JsonIgnore
    private String password;
    private String role;
}
