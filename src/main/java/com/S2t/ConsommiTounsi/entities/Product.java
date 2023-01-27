package com.S2t.ConsommiTounsi.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")
@Data

public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "reference")
    private String reference;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Pattern(regexp = "^619.{10}$", message = "code à Barre")
    @Column(name = "codeBarre")
    private String codeBarre;

    @Column(nullable = true, length = 64)
    private String image;

    @Column(name = "quantity")
    private double quantity;
    @Column(name = "tva")
    private Double tva;


    @JsonIgnore
    //list_ligne_commande
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<LigneCommand> ligneCommandList;

    /*@JsonIgnore
    @ManyToOne
    private Stock stock;*/
    @JsonIgnore
    @ManyToOne
    private User user;

    //public String getImage(){
    //   return "http://localhost:8090/consommitounsi/images/get/"+image;
    // }
    public  String getImageName(){
        return image;
    }
}
