package com.S2t.ConsommiTounsi.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

    @Entity
    @Table(name = "factures")
    @Data
    public class Facture implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private long id;

        @Enumerated(EnumType.STRING)
        private TypeFact typeFact;

        private Date date;

        private String etat_livraison;

  /* @OneToMany
    private Paiement paiement;*/

        @ManyToOne
        private User user;

        @ManyToOne
        private Livraison livraison;



    }


