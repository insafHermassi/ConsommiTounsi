package com.S2t.ConsommiTounsi.service;
import com.S2t.ConsommiTounsi.entities.Facture;
import com.S2t.ConsommiTounsi.entities.TypeFact;
import com.S2t.ConsommiTounsi.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class FactureServiceImpl implements FactureService{
    @Autowired
    FactureRepository factureRepository;
    @Override
    public Facture Save(Facture facture) {
        return factureRepository.save(facture);
    }

    @Override
    public Facture getFacture(long id) {
        return factureRepository.findById(id).get();
    }

    @Override
    public List<Facture> getFacture() {
        return factureRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteFacture(long id) {
        factureRepository.deleteById(id);
        Map<String, Boolean> res = new HashMap<>();
        res.put("deleted", Boolean.TRUE);
        return res;
    }

    @Override
    public Facture updateFcture(long id, Facture facture) {
        Facture old = getFacture(id);
        old.setDate(facture.getDate());
        old.setTypeFact(facture.getTypeFact());
        return factureRepository.save(old);
    }

    @Override
    public List<Facture> findBytypeFact(TypeFact typeFact) {
        return factureRepository.findBytypeFact(typeFact);
    }

    @Override
    public List<Facture> findBydate(Date date) {
        return factureRepository.findBydate(date);
    }
}

