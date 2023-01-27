package com.S2t.ConsommiTounsi.Dto;

import lombok.Data;

import java.time.LocalDate;
    @Data
    public class CommandDto {
        private Long id;
        private Long idClient;

        private LocalDate dateComm;

        private double tva;

    }


