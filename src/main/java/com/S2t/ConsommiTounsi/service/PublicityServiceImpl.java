package com.S2t.ConsommiTounsi.service;


import com.S2t.ConsommiTounsi.entities.CanalPub;
import com.S2t.ConsommiTounsi.entities.Population;
import com.S2t.ConsommiTounsi.entities.Publicity;
import com.S2t.ConsommiTounsi.repository.PublicityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PublicityServiceImpl implements PublicityService{
    @Autowired
    PublicityRepository publicityRepository;



    @Override
    public Publicity Save(Publicity publicity) {
        return publicityRepository.save(publicity);
    }

    @Override
    public Publicity getPublicity(long id) {
        return publicityRepository.findById(id).get();
    }

    @Override
    public List<Publicity> getPublicity() {
        return publicityRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deletePublicity(long id) {
        publicityRepository.deleteById(id);
        Map<String, Boolean> res = new HashMap<>();
        res.put("deleted", Boolean.TRUE);
        return res;
    }


    @Override
    public Publicity updatePublicity(long id, Publicity publicity) {
        Publicity old = getPublicity(id);
        old.setCanalPub(publicity.getCanalPub());
        old.setCoutPub(publicity.getCoutPub());
        old.setTypePub(publicity.getTypePub());
        old.setNbrOfViews(publicity.getNbrOfViews());
        old.setStartDate(publicity.getStartDate());
        old.setEndDate(publicity.getEndDate());
        old.setNamePub(publicity.getNamePub());
        old.setPopulation(publicity.getPopulation());


        return publicityRepository.save(old);
    }

    @Override
    public List<Publicity> findByPopulation(Population population) {
        return publicityRepository.findByPopulation(population);
    }

    @Override
    public List<Publicity> findBytypePub(String typePub) {
        return publicityRepository.findBytypePub(typePub);
    }


   /* @Override
    public List<Publicity> searchByCanalPub(CanalPub canalPub) {
        return publicityRepository.findByCanalPub(canalPub);
    }*/


    @Override
    public List<Publicity> advancedSearach(CanalPub canalPub, double nbrOfViews) {
        return publicityRepository.findByCanalPubAndNbrOfViews(canalPub, nbrOfViews);
    }


}
