package com.codewithratchez.blog.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter @ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false, length = 10000)
    private String studentId;
    @Column(name = "user_name", nullable = false, length = 100)
    private String name;
    private String email;
    private String password;
    private String about;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();
}
