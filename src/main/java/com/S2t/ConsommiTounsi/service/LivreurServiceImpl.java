package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.Livreur;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;
import com.S2t.ConsommiTounsi.repository.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class LivreurServiceImpl implements LivreurService{
    @Autowired
    LivreurRepository  livreurRepository;
    @Override
    public Livreur save(Livreur livreur) {
        return livreurRepository.save(livreur);
    }

    @Override
    public Livreur getLivreur(Long id) throws RessourcesNotFound {
        Livreur livreur= livreurRepository.findById(id).orElseThrow(()-> new RessourcesNotFound("livreur not found for id :"+id));
        return livreur;
    }

    @Override
    public List<Livreur> getLivreurs() {
        return  (List<Livreur>) livreurRepository.findAll() ;
    }

    @Override
    public Map<String, Boolean> deleteLivreur(Long id) {
        livreurRepository.deleteById(id);
        Map<String,Boolean> res = new HashMap<>();
        res.put("deleted",Boolean.TRUE);
        return res;    }

    @Override
    public Livreur findByPlace(String place) {
        return livreurRepository.findByPlace(place);
    }

    @Override
    public Livreur update(Long id, Livreur livreur) throws RessourcesNotFound {
        Livreur lv=getLivreur(id);
        lv.setDisponibilite(livreur.getDisponibilite());
        lv.setMaps(livreur.getMaps());
        lv.setPlace(livreur.getPlace());
        lv.setPrime(livreur.getPrime());
        lv.setSalaire(livreur.getSalaire());
        lv.setStatique(livreur.getStatique());
        lv.setCharge(livreur.getCharge());
        return livreurRepository.save(lv);
    }
}
