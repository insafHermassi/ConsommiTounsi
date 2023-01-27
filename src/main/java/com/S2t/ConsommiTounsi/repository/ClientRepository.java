package com.S2t.ConsommiTounsi.repository;

import com.S2t.ConsommiTounsi.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
    @Repository
    public interface ClientRepository extends JpaRepository<Client, Long> {

        public List<Client> findByFirstnameOrLastname(String firstname, String lastname);
    }


