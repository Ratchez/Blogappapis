package com.codewithratchez.blog.repositories;

import com.codewithratchez.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByStudentId(String userId);
}
