package com.S2t.ConsommiTounsi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="clients")
@Data
public class Client extends User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String firstname;

    private String lastname;

    private String address;

    private String email;

    private  String phone;


    @JsonIgnore
    //list_command
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    private List<Command> ListCommand;
}

