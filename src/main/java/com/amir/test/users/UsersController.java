package com.amir.test.users;

import com.amir.test.models.Users;
import com.amir.test.users.dto.RegisterDto;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Users addUser(@Valid @RequestBody RegisterDto body){
        return usersService.createUser(body);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Users> getUsers(Principal principal){
        return  usersService.getUsers();
    }
}
