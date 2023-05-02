package com.codewithratchez.blog.repositories;

import com.codewithratchez.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Integer> {

}
