package com.S2t.ConsommiTounsi.repository;

import com.S2t.ConsommiTounsi.entities.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface CommandRepository extends JpaRepository<Command, Long> {
    public List<Command> findByNumComm(String numComm);
    public  List<Command> findBydateComm(Date dateComm);
}
