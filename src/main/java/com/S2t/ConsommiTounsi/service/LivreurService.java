package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.Livreur;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;

import java.util.List;
import java.util.Map;

public interface LivreurService {
    public Livreur save(Livreur livreur);
    public Livreur getLivreur(Long id) throws RessourcesNotFound;

    public List<Livreur> getLivreurs();
    public Map<String,Boolean> deleteLivreur(Long id);

    public Livreur findByPlace(String place);

    public Livreur update(Long id, Livreur livreur) throws RessourcesNotFound;
}
