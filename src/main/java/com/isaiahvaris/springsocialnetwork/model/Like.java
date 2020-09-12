package com.isaiahvaris.springsocialnetwork.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "likes")
//@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"user", "post"})})
public class Like implements Serializable {

    /*
    Post entity fields/columns
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int likeId;
    /*
    Like has a many to one relationship with user and post
     */
    @ManyToOne
    private User user;
    @ManyToOne
    private Post post;
}

