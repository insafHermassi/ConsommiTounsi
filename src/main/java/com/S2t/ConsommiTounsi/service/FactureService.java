package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.Facture;
import com.S2t.ConsommiTounsi.entities.TypeFact;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface FactureService {
    public Facture Save(Facture facture);

    public Facture getFacture(long id);

    public List<Facture> getFacture();

    public Map<String, Boolean> deleteFacture(long id);

    public Facture updateFcture(long id, Facture facture);

    public List<Facture> findBytypeFact(TypeFact typeFact);

    public List<Facture> findBydate(Date date);
}
