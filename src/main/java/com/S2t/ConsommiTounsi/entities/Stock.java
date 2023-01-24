package com.S2t.ConsommiTounsi.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Table(name = "stock")
@Entity
@Data
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "code")
    private  String code;

    @Column(name = "quantityProd")
    private  double quantityProd;

    @Column(name = "quantityMin")
    private double quantityMin;


}
