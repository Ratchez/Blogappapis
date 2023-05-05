package com.codewithratchez.blog.payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;
    @NotEmpty
    @NotBlank
    @Size(min = 4, message = "Username must be have min of 4 characters")
    private String name;
    @Email(message = "Email address is not valid")
    @NotBlank
    private String email;

    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 10, message = "Password must be min of 3 chars and max of 10 chars")
    private String password;
    @NotEmpty
    private String about;

    private String studentId;
}
