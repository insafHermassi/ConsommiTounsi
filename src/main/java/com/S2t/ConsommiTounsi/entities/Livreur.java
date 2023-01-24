package com.S2t.ConsommiTounsi.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Table(name="livreurs")
@Data
public class Livreur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  = "id", nullable = false)
    private long id;
    @Column(name = "firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "city")
    private String city;
    @Email
    @Column(name = "email")
    private String email;


    @Column(name="salary")
    private double salary;

    @Column(name ="isAvailable")
    private boolean isAvailable;

    @Column(name = "nbrLivraison")
    private double nbrLivraison;
}
