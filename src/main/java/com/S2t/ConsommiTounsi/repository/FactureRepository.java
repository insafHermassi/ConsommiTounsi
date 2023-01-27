package com.S2t.ConsommiTounsi.repository;
import com.S2t.ConsommiTounsi.entities.Facture;
import com.S2t.ConsommiTounsi.entities.TypeFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
    @Repository
    public interface FactureRepository extends JpaRepository<Facture, Long> {

        public List<Facture> findBydate(Date date);
        public List<Facture>findBytypeFact(TypeFact typeFact);
}
