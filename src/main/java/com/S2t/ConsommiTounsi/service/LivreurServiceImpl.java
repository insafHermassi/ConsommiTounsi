package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.Livreur;
import com.S2t.ConsommiTounsi.repository.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class LivreurServiceImpl implements LivreurService{
    @Autowired
    LivreurRepository livreurRepository;


    @Override
    public Livreur Save(Livreur livreur) {
        return livreurRepository.save(livreur);
    }

    @Override
    public Livreur getLivreur(long id) {
        return livreurRepository.findById(id).get();
    }

    @Override
    public List<Livreur> getLivreur() {
        return livreurRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteLivreur(long id) {
        livreurRepository.deleteById( id);
        Map<String,Boolean>res=new HashMap<>();
        res.put("deleted",Boolean.TRUE);
        return res;
    }

    @Override
    public Livreur updateLivreur(long id, Livreur livreur) {
       Livreur old=getLivreur(id);
       old.setSalary(livreur.getSalary());
       old.setNbrLivraison(livreur.getNbrLivraison());
       old.setFirstname(livreur.getFirstname());
       old.setLastname(livreur.getLastname());
       old.setEmail(livreur.getEmail());
        return livreurRepository.save(old);
    }

    @Override
    public List<Livreur> findBycity(String city) {
        return livreurRepository.findBycity(city);
    }

    @Override
    public List<Livreur> searchByisAvailable(boolean isAvailable) {
        return livreurRepository.findByisAvailable(isAvailable);
    }

    @Override
    public List<Livreur> findByFirstnameOrlastname(String firstname, String lastname) {
        return livreurRepository.findByFirstnameOrLastname(firstname,lastname);
    }

    @Override
    public List<Livreur> searchBynbrLivraison(double nbrLivraison) {
        return livreurRepository.findBynbrLivraison(nbrLivraison);
    }
}
