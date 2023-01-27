package com.S2t.ConsommiTounsi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name= "livreurs")
@Data
public class Livreur  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private Boolean disponibilite;

    private String maps;
    private String place;
    private double prime;
    private double salaire;
    private double statique;
    private int charge ;

    @JsonIgnore
    @OneToMany(mappedBy = "livreur", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Livraison> livraison;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrime() {

        if (charge <= 10) {
            prime = 0.10;
        } else if (charge > 10 && charge <= 20) {
            prime = 0.15;
        } else if (charge > 20 && charge <= 30) {
            prime = 0.20;
        } else if (charge > 30 && charge <= 40) {
            prime = 0.25;
        } else {
            prime = 0.30;
        }
        return this.prime=prime;
    }
}

