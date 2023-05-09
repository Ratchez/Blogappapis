package com.codewithratchez.blog.controllers;

import com.codewithratchez.blog.payloads.ApiResponse;
import com.codewithratchez.blog.payloads.UserDto;
import com.codewithratchez.blog.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    // POST-create user
    @PostMapping()
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createdUser = userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // PUT-update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer userId){
        UserDto updateUser = userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updateUser);
    }

    //ADMIN
    // DELETE-delete user
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId){
        userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully"), HttpStatus.OK);
    }

    // GET - user gets all users
    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // GET - user gets specific user
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable String userId){
        return ResponseEntity.ok(userService.getUserByStudentId(userId));
    }
}
