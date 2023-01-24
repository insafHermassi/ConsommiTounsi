package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.Sujet;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SujetService {

    public Sujet Save(Sujet sujet);

    public Sujet getSujet(long id);

    public List<Sujet> getSujet();

    public Map<String, Boolean> deleteSujet(long id);

    public Sujet updateSujet(long id, Sujet sujet);

    public List<Sujet> findByTitle(String title);

    public List<Sujet> searchBycreateDat(Date createDat);

    //public List<Sujet> orderedBynumberOfStars(double numberOfStars);
}

