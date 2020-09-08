package com.isaiahvaris.springsocialnetwork.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "First name is required")
    private String first_name;
    @NotBlank(message = "Last name is required")
    private String last_name;
    @NotBlank(message = "email is required")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "password is required")
    private String pass_word;
    @NotBlank(message = "gender is required")
    private String gender;
    @NotBlank(message = "date of birth is required")
    private Date birth_day;

//    @OneToMany(mappedBy = "user")
//    private Set<Post> posts = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes;

}
