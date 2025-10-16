package com.tay.springSecurityWithJWT2.repository;

import com.tay.springSecurityWithJWT2.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    boolean existsByUsername(String username);

    Optional<UserModel>findByUsername(String username);
}
