package com.codewithratchez.blog.services;

import com.codewithratchez.blog.payloads.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDto registerNewUser(UserDto user);
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserByStudentId(String userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}
