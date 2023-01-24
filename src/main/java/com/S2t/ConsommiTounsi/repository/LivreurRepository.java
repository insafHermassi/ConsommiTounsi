package com.S2t.ConsommiTounsi.repository;

import com.S2t.ConsommiTounsi.entities.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreurRepository extends JpaRepository<Livreur,Long> {
    public List<Livreur> findByFirstnameOrLastname(String firstname, String lastname);

    public List<Livreur>findBycity(String city);

    public List<Livreur>findByisAvailable(Boolean isAvailable);
    public List<Livreur>findBynbrLivraison(Double nbrLivraison);


}
