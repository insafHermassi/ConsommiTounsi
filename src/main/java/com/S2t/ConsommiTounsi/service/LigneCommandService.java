package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.Dto.LigneCommandDto;
import com.S2t.ConsommiTounsi.entities.LigneCommand;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface LigneCommandService {
    public LigneCommand save(LigneCommandDto ligneCommandDto) throws RessourcesNotFound;
    public LigneCommand getLigneCommand(Long id);
    public List<LigneCommand> getLigneCommnands();
    public Map<String,Boolean> deleteLigneCommand(Long id);
    public List<LigneCommand> searchByDate(Date date);
    public List<LigneCommand> searchByCommand(Long id);
    public List<LigneCommand>  searchByProduct(Long id);
    public LigneCommand updateLigneCommand(LigneCommandDto ligneCommandDto);
}
