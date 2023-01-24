package com.S2t.ConsommiTounsi.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sujet")
public class Sujet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "createDat")
    @Temporal(TemporalType.DATE)
    private Date createDat;
    @Column(name = "updateDat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDat;
    @Column(name = "numberOfStars")
    double numberOfStars;
}

