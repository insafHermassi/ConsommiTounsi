package com.S2t.ConsommiTounsi.repository;

import com.S2t.ConsommiTounsi.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Stack;
@Repository
public interface StockRepository extends CrudRepository<Stock,Long> {

    public List<Stock>findBycode(String code);
}