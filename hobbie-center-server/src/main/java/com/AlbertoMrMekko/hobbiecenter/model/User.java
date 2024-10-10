package com.AlbertoMrMekko.hobbiecenter.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "password")
    private String password;

    @Column(name = "avatar_url")
    private String avatarUrl;

    // TODO constructor
}
