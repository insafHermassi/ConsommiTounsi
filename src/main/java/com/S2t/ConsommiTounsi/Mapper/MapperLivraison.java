package com.S2t.ConsommiTounsi.Mapper;

import com.S2t.ConsommiTounsi.Dto.LivraisonDto;
import com.S2t.ConsommiTounsi.entities.Command;
import com.S2t.ConsommiTounsi.entities.Livraison;
import com.S2t.ConsommiTounsi.entities.Livreur;
import com.S2t.ConsommiTounsi.entities.Status;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;
import com.S2t.ConsommiTounsi.service.CommandService;
import com.S2t.ConsommiTounsi.service.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;


    @Component
    public class MapperLivraison implements Serializable {
        @Autowired
        LivreurService livreurService;
        @Autowired
        CommandService commandService;

        public Livraison dtoToEntity(LivraisonDto livraisonDto) throws RessourcesNotFound {
            Livraison livraison = new Livraison();
            Command command = commandService.getCommand(livraisonDto.getIdCommand());
            livraison.setCommand(command);
            Livreur livreur = livreurService.getLivreur(livraisonDto.getIdLivreur());
            livraison.setLivreur(livreur);
            livraison.setPoids(livraisonDto.getPoids());
            livraison.setTransporter(livraisonDto.getTransporter());
            livraison.setDateLiv(livraisonDto.getDate());
            livraison.setAddress(command.getClient().getAddress());
            livraison.setFrais(livraisonDto.getFrais());
            livraison.setStatus(Status.untreated);
            return livraison;
        }


        public LivraisonDto entityToDto(Livraison livraison) {
            LivraisonDto livraisonDto = new LivraisonDto();
            livraisonDto.setId(livraison.getId());
            livraisonDto.setIdCommand(livraison.getCommand().getId());
            livraisonDto.setIdLivreur(livraison.getLivreur().getId());
            livraisonDto.setFrais(livraison.getFrais());
            livraisonDto.setPoids(livraison.getPoids());
            livraisonDto.setTransporter(livraison.getTransporter());
            livraisonDto.setStatus(Status.untreated);

            return livraisonDto;

        }
        public List<LivraisonDto> entityListToDto(List <Livraison> entities ){
            return entities.stream().map( item ->entityToDto(item)).collect(Collectors.toList());
        }
    }


