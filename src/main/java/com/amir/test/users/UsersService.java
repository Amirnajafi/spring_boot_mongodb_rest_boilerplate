package com.amir.test.users;

import com.amir.test.models.ERole;
import com.amir.test.models.Users;
import com.amir.test.users.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsersService {
    private final UsersRepository usersRepository;
    
    @Autowired
    PasswordEncoder encoder;
    public List<Users> getUsers(){
        return usersRepository.findAll();
    }
    public Users getUserByUsername(String username){
        Users user = usersRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
            return user;
    }
    public Users createUser(RegisterDto body){
        Users user = Users.builder()
                .name(body.getName())
                .family(body.getFamily())
                .username(body.getUsername())
                .password(encoder.encode(body.getPassword()))
                .role(String.valueOf(ERole.ROLE_USER))
                .build();
        usersRepository.save(user);
        return user;
    }
}
