package com.S2t.ConsommiTounsi.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


    @Entity
    @Table(name = "publicity")
    @Data
    public class Publicity implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private long id;

        @Column(name = "namePub")
        private String namePub;

        @Column(name = "startDate")
        private Date startDate;

        @Column(name = "endDate")
        private Date endDate;

        @Column(name = "nbrOfViews")
        private double nbrOfViews;

        @Column(name = "coutPub")
        private double coutPub;

        @Column(name = "typePub")
        private String typePub;

        @Enumerated(EnumType.STRING)
        private Population population;

        @Enumerated(EnumType.STRING)
        private CanalPub canalPub;


    }


