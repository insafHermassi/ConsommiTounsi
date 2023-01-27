package com.S2t.ConsommiTounsi.repository;
import com.S2t.ConsommiTounsi.entities.Livraison;
import com.S2t.ConsommiTounsi.entities.Livreur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
    @Repository
    public interface LivraisonRepository extends CrudRepository<Livraison,Long> {
        public List<Livraison> findByLivreur (Livreur livreur);
    }


