package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.Dto.CommandDto;
import com.S2t.ConsommiTounsi.Mapper.MapperCommand;
import com.S2t.ConsommiTounsi.entities.Client;
import com.S2t.ConsommiTounsi.entities.Command;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;
import com.S2t.ConsommiTounsi.repository.ClientRepository;
import com.S2t.ConsommiTounsi.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandServiceImpl implements CommandService{
    @Autowired
    CommandRepository commandRepository;
    @Autowired
    MapperCommand mapperCommand;

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ClientService clientService;
    @Override
    public Command save(long idClient, Double tva)  {

        Client client = clientRepository.findById(idClient).get();
        Command command = new Command();
        command.setClient(client);
        command.setDateComm(LocalDate.now());
        command.setTva(tva);

        return commandRepository.save(command);
    }

    @Override
    public Command getCommand(long id) {
        return commandRepository.findById(id).get();
    }

    @Override
    public List<Command> getCommands() {
        return (List<Command>)commandRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteCommand(long id) {
        commandRepository.deleteById(id);
        Map<String,Boolean> res = new HashMap<>();
        res.put("deleted",Boolean.TRUE);
        return res;
    }

    @Override
    public List<Command> searchCommandByNumComm(String numComm) {
        return commandRepository.findByNumComm(numComm);
    }

    @Override
    public List<Command> searchCommandBydateComm(Date dateComm) {
        return commandRepository.findBydateComm(dateComm);
    }

    @Override
    public Command updateCommand(long id, CommandDto commandDto) throws RessourcesNotFound {

        Command command= commandRepository.findById(id).orElseThrow(
                ()-> new RessourcesNotFound("Command not found for id:"+id));

        command.setClient(clientService.getClient(commandDto.getIdClient()));
        command.setDateComm(LocalDate.now());
        command.setTva(commandDto.getTva());

        return commandRepository.save(command);
    }
}
