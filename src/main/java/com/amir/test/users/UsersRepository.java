package com.amir.test.users;

import com.amir.test.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsersRepository extends MongoRepository<Users, String> {
    Optional<Users> findByUsername(String username);

    Boolean existsByUsername(String username);

}