package com.S2t.ConsommiTounsi.Mapper;

import com.S2t.ConsommiTounsi.Dto.CommandDto;
import com.S2t.ConsommiTounsi.entities.Client;
import com.S2t.ConsommiTounsi.entities.Command;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;
import com.S2t.ConsommiTounsi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
    @Component
    public class MapperCommand {
        @Autowired
        ClientService clientService;


        public Command dtoToEntity(CommandDto commandDto) throws RessourcesNotFound {
            Command command = new Command();
            Client client = clientService.getClient(commandDto.getIdClient());
            command.setClient(client);
            command.setDateComm(LocalDate.now());
            return command;
        }
        public CommandDto entityToDto(Command command){
            CommandDto commandDto = new CommandDto();
            commandDto.setId(command.getId());
            commandDto.setIdClient(command.getClient().getId());
            commandDto.setDateComm(LocalDate.now());
            commandDto.setTva(command.getTva());

            return commandDto;
        }
        public List<CommandDto> entitiesToListDto(List<Command> entities){
            return entities.stream().map(item->entityToDto(item)).collect(Collectors.toList());
        }
    }


