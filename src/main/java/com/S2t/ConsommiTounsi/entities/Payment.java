package com.S2t.ConsommiTounsi.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



    @Data
    @Table(name = "paies")
    @Entity
    public class Payment implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private long id;

        @Enumerated(EnumType.STRING)
        private TypePai typePai;

        private Date date;
        private  long card;
   /*  @OneToOne(mappedBy = "paiement")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Command command;*/




    }


