package com.S2t.ConsommiTounsi.Dto;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

    @Data
    public class LigneCommandDto  implements Serializable {

        private Long id ;

        private Long idProduct ;

        private Long idCommand ;

        private Long quantity;

        private Date date;

        private double sousTotale;

        private double totale;


    }


