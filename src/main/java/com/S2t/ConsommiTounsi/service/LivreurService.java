package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.Livreur;

import java.util.List;
import java.util.Map;

public interface LivreurService {
    public Livreur Save(Livreur livreur);

    public Livreur getLivreur(long id);

    public List<Livreur> getLivreur();

    public Map<String, Boolean> deleteLivreur(long id);

    public Livreur updateLivreur(long id, Livreur livreur);

    public List<Livreur> findBycity(String city);
    public List<Livreur> searchByisAvailable(boolean isAvailable);

    public List<Livreur> findByFirstnameOrlastname(String firstname, String lastname);
    public List<Livreur> searchBynbrLivraison(double nbrLivraison );
}
