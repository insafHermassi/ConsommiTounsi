package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.Dto.CommandDto;
import com.S2t.ConsommiTounsi.entities.Command;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CommandService {
    public Command save (long idClient, Double tva) ;
    public Command getCommand(long id) ;
    public List<Command> getCommands();
    public Map<String,Boolean> deleteCommand(long id);
    public List<Command> searchCommandByNumComm(String numComm);
    public List<Command> searchCommandBydateComm(Date dateComm);
    public Command updateCommand(long id, CommandDto commandDto) throws RessourcesNotFound;
}
