package com.S2t.ConsommiTounsi.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name ="livraison" )
@Data
public class Livraison implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "address is mandatory")
    @Column(nullable = false)
    private String address; ;
    private Date dateLiv;
    private double frais;
    private double poids;
    private Status status;
    private MoyeTransport transporter;

    @OneToOne
    @JoinColumn(name = "comm_id", referencedColumnName = "id")
    private Command command;
    @ManyToOne
    @JoinColumn(name = "livreur_id", referencedColumnName = "id")
    private Livreur livreur;

    public double calculFrais() {
        if(address.equals("tunis")){
            switch (transporter) {
                case moto:
                    this.frais = poids * 0.2;
                    break;
                case car:
                    this. frais = poids * 0.3;
                    break;
                case camion:
                    this. frais = poids * 0.5;
                    break;
            }}
        else{
            this.frais= poids * 0.8;
        }
        return frais;

    }

}

