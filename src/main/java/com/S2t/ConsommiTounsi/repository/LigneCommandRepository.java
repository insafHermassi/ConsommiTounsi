package com.S2t.ConsommiTounsi.repository;

import com.S2t.ConsommiTounsi.entities.LigneCommand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface LigneCommandRepository extends JpaRepository<LigneCommand, Long> {
    public List<LigneCommand> findByDate(Date date);
    public List<LigneCommand> findByCommand(long id);
    public List<LigneCommand> findByProduct(long id);
}
