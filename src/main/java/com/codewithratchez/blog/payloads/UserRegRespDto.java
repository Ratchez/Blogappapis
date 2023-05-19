package com.codewithratchez.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserRegRespDto {
    private int id;
    @NotEmpty
    @NotBlank
    @Size(min = 4, message = "Username must be have min of 4 characters")
    private String name;
    @Email(message = "Email address is not valid")
    @NotBlank
    private String email;

    @NotEmpty
    private String about;

    private String bloggerId;

//    private Set<RoleDto> roles = new HashSet<>();
}
