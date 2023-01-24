package com.S2t.ConsommiTounsi.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "store")
@Entity
@Data
public class Store implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Enumerated(EnumType.STRING)
    private TypeRay typeRay;

    @Enumerated(EnumType.STRING)
    private Category category;

}
