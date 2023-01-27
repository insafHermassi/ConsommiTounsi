package com.S2t.ConsommiTounsi.Dto;
import com.S2t.ConsommiTounsi.entities.MoyeTransport;
import com.S2t.ConsommiTounsi.entities.Status;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
@Data
public class LivraisonDto implements Serializable {
    private Long id;
    private Long idLivreur;
    private Long idCommand;
    private double poids;
    private double frais;
    private Date date;
    private Status status;
    private MoyeTransport transporter;
}
