package com.codewithratchez.blog.services.impl;

import com.codewithratchez.blog.entities.User;
import com.codewithratchez.blog.exceptions.ResourceNotFoundException;
import com.codewithratchez.blog.payloads.UserDto;
import com.codewithratchez.blog.repositories.UserRepo;
import com.codewithratchez.blog.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto){
        User user = this.dtoToUser(userDto);

        user.setStudentId(UUIDGenerator(user));
        log.info(user.toString());
        User savedUser = userRepo.save(user);
        log.info("User with name {} created with student Id {}", savedUser.getName(), savedUser.getStudentId());
        return this.userToDto(savedUser);
    }
    @Override
    public UserDto updateUser(UserDto userDto, Integer userId){
        User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser = userRepo.save(user);
        UserDto userDto1 = this.userToDto(updatedUser);
        return userDto1;
    }
    @Override
    public UserDto getUserByStudentId(String userId){
        User user = userRepo.findByStudentId(userId).orElseThrow(() -> new ResourceNotFoundException("User"));
        return this.userToDto(user);
    }
    @Override
    public List<UserDto> getAllUsers(){
        List<User> users = userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }
    public void deleteUser(Integer userId){
        User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"));
        userRepo.delete(user);
    }
    private User dtoToUser(UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setAbout(userDto.getAbout());
//        user.setPassword(userDto.getPassword());
        return user;
    }
    private UserDto userToDto(User user){
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    private String UUIDGenerator(User user) {
        log.info(String.valueOf(user.hashCode()));
        return String.valueOf(user.hashCode());
    }
}
