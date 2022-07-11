package com.amir.test.users;

import com.amir.test.users.dto.CreateUsersDto;
import com.amir.test.models.Users;
import com.amir.test.users.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsersService {
    private final UsersRepository usersRepository;

    public List<Users> getUsers(){
        return usersRepository.findAll();
    }

    public Users createUser(RegisterDto body){
        Users user = Users.builder()
                .name(body.getName())
                .family(body.getFamily())
                .username(body.getUsername())
                .build();

        log.info(user.toString());
        usersRepository.save(user);

        return user;
    }
}
