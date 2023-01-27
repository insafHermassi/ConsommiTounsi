package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.CanalPub;
import com.S2t.ConsommiTounsi.entities.Population;
import com.S2t.ConsommiTounsi.entities.Publicity;

import java.util.List;
import java.util.Map;

public interface PublicityService {
    public Publicity Save(Publicity publicity);

    public Publicity getPublicity(long id);

    public List<Publicity> getPublicity();

    public Map<String, Boolean> deletePublicity(long id);

    public Publicity updatePublicity(long id, Publicity publicity);

    public List<Publicity> findByPopulation(Population population);

//    public List<Publicity> searchByCanalPub(CanalPub canalPub);

    public List<Publicity> findBytypePub(String typePub);

    public List<Publicity> advancedSearach(CanalPub canalPub, double nbrOfViews);

}

