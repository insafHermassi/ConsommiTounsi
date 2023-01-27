package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.Dto.LigneCommandDto;
import com.S2t.ConsommiTounsi.Mapper.MapperLigneCommand;
import com.S2t.ConsommiTounsi.entities.Command;
import com.S2t.ConsommiTounsi.entities.LigneCommand;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;
import com.S2t.ConsommiTounsi.repository.CommandRepository;
import com.S2t.ConsommiTounsi.repository.LigneCommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LigneCommandServiceImpl implements LigneCommandService {
    @Autowired
    LigneCommandRepository ligneCommandRepository;
    @Autowired
    CommandRepository commandRepository;
    @Autowired
    MapperLigneCommand mapperLigneCommand;

    @Override
    public LigneCommand save(LigneCommandDto ligneCommandDto) throws RessourcesNotFound {
        LigneCommand ligneCommand =mapperLigneCommand.dtoToEntity(ligneCommandDto);
        ligneCommand.calculerSomme();
        ligneCommandRepository.save(ligneCommand);
        Command command=ligneCommand.getCommand();
        command.increase(ligneCommand.getSousTotale());
        commandRepository.save(command);
        return ligneCommand;
    }

    @Override
    public LigneCommand getLigneCommand(Long id) {

        return ligneCommandRepository.findById(id).get();
    }

    @Override
    public List<LigneCommand> getLigneCommnands() {

        return (List<LigneCommand>) ligneCommandRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteLigneCommand(Long id) {
        // ligneCommandRepository.deleteById(id);
        LigneCommand ligneCommand=getLigneCommand(id);

        //recupere command from ligneCommand
        Command command = ligneCommand.getCommand();
        command.decrease(ligneCommand.getSousTotale());
        //supprimer ligneCommand
        ligneCommandRepository.delete(ligneCommand);
        Map<String,Boolean> res = new HashMap<>();
        res.put("deleted",Boolean.TRUE);
        return res;

    }


    @Override
    public List<LigneCommand> searchByDate(Date date) {

        return ligneCommandRepository.findByDate(date);
    }

    @Override
    public List<LigneCommand> searchByCommand(Long id) {

        return ligneCommandRepository.findByCommand(id);
    }

    @Override
    public List<LigneCommand> searchByProduct(Long id) {

        return ligneCommandRepository.findByProduct(id);
    }

    @Override
    public LigneCommand updateLigneCommand(LigneCommandDto ligneCommandDto) {
        LigneCommand old = getLigneCommand(ligneCommandDto.getIdCommand());

        return null;
    }
}


