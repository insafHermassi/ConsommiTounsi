package com.S2t.ConsommiTounsi.Mapper;

import com.S2t.ConsommiTounsi.Dto.LigneCommandDto;
import com.S2t.ConsommiTounsi.entities.Command;
import com.S2t.ConsommiTounsi.entities.LigneCommand;
import com.S2t.ConsommiTounsi.entities.Product;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;
import com.S2t.ConsommiTounsi.service.CommandService;
import com.S2t.ConsommiTounsi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

    @Component
    public class MapperLigneCommand implements Serializable {
        @Autowired
        CommandService commandService;

        @Autowired
        MapperCommand mapperCommand;
        @Autowired
        ProductService productService;

        public LigneCommand dtoToEntity(LigneCommandDto ligneCommandDto) throws RessourcesNotFound {
            LigneCommand ligneCommand = new LigneCommand();

            Command command = commandService.getCommand(ligneCommandDto.getIdCommand());
            Product product = productService.getProduct(ligneCommandDto.getIdProduct());
            ligneCommand.setCommand(command);
            ligneCommand.setProduct(product);
            ligneCommand.setQuantity(ligneCommandDto.getQuantity());
            ligneCommand.setSousTotale(ligneCommandDto.getSousTotale());
            ligneCommand.setDate(ligneCommandDto.getDate());

            return ligneCommand;
        }
        public LigneCommandDto entityToDto(LigneCommand ligneCommand){
            LigneCommandDto ligneCommandDto = new LigneCommandDto();
            ligneCommandDto.setId(ligneCommand.getId());
            ligneCommandDto.setIdCommand(ligneCommand.getCommand().getId());
            ligneCommandDto.setIdProduct(ligneCommand.getProduct().getId());
            ligneCommandDto.setSousTotale(ligneCommand.getSousTotale());
            ligneCommandDto.setTotale(ligneCommand.getTotale());
            ligneCommandDto.setQuantity(ligneCommand.getQuantity());
            return ligneCommandDto;

        }
    }









