package com.S2t.ConsommiTounsi.repository;

import com.S2t.ConsommiTounsi.entities.CanalPub;
import com.S2t.ConsommiTounsi.entities.Population;
import com.S2t.ConsommiTounsi.entities.Publicity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface PublicityRepository extends JpaRepository<Publicity, Long> {

//public List<Publicity> findByCanalPub(CanalPub canalPub);


        public List<Publicity> findByPopulation(Population population);

        public List <Publicity> findByCanalPubAndNbrOfViews(CanalPub canalPub, Double nbrOfViews);

        public List<Publicity> findBytypePub(String typePub);

    }
