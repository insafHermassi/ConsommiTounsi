package com.S2t.ConsommiTounsi.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

    @Entity
    @Table(name="users")
    @Data
    public  abstract class User implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name  = "id", nullable = false)
        private long id;

        @Column(name = "username", unique = true)
        private  String username;

        @Column(name = "password")
        private String password;

        @Email
        @Column(name = "email", unique = true)
        private  String email;
    }



