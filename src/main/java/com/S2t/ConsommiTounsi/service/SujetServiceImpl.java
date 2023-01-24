package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.Sujet;
import com.S2t.ConsommiTounsi.repository.SujetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SujetServiceImpl implements SujetService{
    @Autowired
    SujetRepository sujetRepository;

    @Override
    public Sujet Save(Sujet sujet) {

        return sujetRepository.save(sujet);

    }

    @Override
    public Sujet getSujet(long id) {
        return sujetRepository.findById(id).get();
    }


    @Override
    public List<Sujet> getSujet() {
        return  sujetRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteSujet(long id) {
        sujetRepository.deleteById(id);
        Map<String, Boolean> res = new HashMap<>();
        res.put("deleted", Boolean.TRUE);
        return res;
    }

    @Override
    public Sujet updateSujet(long id, Sujet sujet) {
        Sujet old = getSujet(id);
        old.setTitle(sujet.getTitle());
        old.setContent(sujet.getContent());
        old.setUpdateDat(sujet.getUpdateDat());
        old.setCreateDat(sujet.getCreateDat());
        old.setNumberOfStars(sujet.getNumberOfStars());

        return sujetRepository.save(old);
    }

    @Override
    public List<Sujet> findByTitle(String title) {

        return sujetRepository.findByTitle(title);
    }

    @Override
    public List<Sujet> searchBycreateDat(Date createdAt) {
        return sujetRepository.searchBycreateDat(createdAt);
    }

   /* @Override
    public List<Sujet> orderedBynumberOfStars(double numberOfStars) {
        return sujetRepository.orderedBynumberOfStars(numberOfStars);
    }*/

}
