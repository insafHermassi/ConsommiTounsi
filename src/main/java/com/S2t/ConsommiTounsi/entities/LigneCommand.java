package com.S2t.ConsommiTounsi.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

    @Table(name = "ligne_de_commande")
    @Entity
    @Data
    public class LigneCommand implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private long id;
        private long quantity;
        private double sousTotale;
        private Date date;
        private double totale;
        @ManyToOne
        @JoinColumn(name = "idCommand",referencedColumnName = "id")
        private Command command;
        @ManyToOne
        @JoinColumn(name="idProduct",referencedColumnName = "id")
        private Product product;
        public void calculerSomme(){
            this.sousTotale=product.getPrice()*quantity;
        }

    }


