package com.amir.test.users;


import java.util.Optional;

import com.amir.test.models.ERole;
import com.amir.test.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}