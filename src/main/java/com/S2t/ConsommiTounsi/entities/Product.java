package com.S2t.ConsommiTounsi.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.Category;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table
@Data

public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String ref;
    private Double price;
    private String image;
    private double quantity;
    private Double tva;

    private  String CodeBarre;




    // @JsonIgnore
    //list_lignes_commandes
   // @OneToMany(mappedBy = "pro",fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
  //  private List<LigneCommande> ListLignesCommandes;


}
