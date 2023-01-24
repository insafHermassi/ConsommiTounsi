package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.Stock;
import java.util.List;

import java.util.Map;

public interface StockService {

    public Stock Save(Stock stock);

    public Stock getStock(long id);


    public Map<String, Boolean> deleteStock(long id);

    public Stock updateStock(long id, Stock stock);

    public List<Stock> findBycode(String code);
}

