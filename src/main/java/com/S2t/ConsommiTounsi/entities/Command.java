package com.S2t.ConsommiTounsi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Table(name = "command")
@Entity
@Data
public class Command implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numComm;
    // @Temporal(TemporalType.DATE)
    private LocalDate dateComm;
    private double montant;
    private double tva;
    private double totale;

    @ManyToOne
    @JoinColumn(name="idClient",referencedColumnName = "id")
    private Client client;


    @JsonIgnore
    @OneToMany(mappedBy = "command",fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    private List<LigneCommand> ligneCommandList;
    @ManyToOne
    @JoinColumn(name="idLivreur",referencedColumnName = "id")
    private Livreur livreur;
    public void increase(double sousTotale){
        this.totale=this.totale+sousTotale;


    }
    public void decrease(double sousTotale) {
        this.totale=this.totale-sousTotale;
    }


}










