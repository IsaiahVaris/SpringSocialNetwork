package com.isaiahvaris.springsocialnetwork.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "comments")
public class Comment {
    /*
    Comment entity fields/columns
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commentId;
    /*
    Comment has a many to one relationship with user and post
     */
    @ManyToOne
    private User user;
    @ManyToOne
    private Post post;

    @NotBlank(message = "comment body is required")
    private String commentBody;
}
