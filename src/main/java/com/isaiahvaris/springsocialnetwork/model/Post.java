package com.isaiahvaris.springsocialnetwork.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int post_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @NotBlank(message = "First name is required")
    private String message_body;

//    @Column(defaultValue = {@UniqueConstraint(columnNames = {"user_id", "post_id"})})
//    private int num_of_comments = 0;
//    private int num_of_likes = 0;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes;

}
