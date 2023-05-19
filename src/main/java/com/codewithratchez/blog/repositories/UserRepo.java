package com.codewithratchez.blog.repositories;

import com.codewithratchez.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByBloggerId(String bloggerId);
    Optional<User> findByEmail(String email);
}
