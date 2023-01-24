package com.S2t.ConsommiTounsi.repository;

import com.S2t.ConsommiTounsi.entities.Sujet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Repository
public interface SujetRepository extends JpaRepository<Sujet,Long> {

    public List<Sujet> findByTitle(String title);


    public List<Sujet> searchBycreateDat(Date createDat);


    //public List<Sujet> orderedBynumberOfStars(Double numberOfStars);
}