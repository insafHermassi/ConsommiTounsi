package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.Stock;
import com.S2t.ConsommiTounsi.repository.StockRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockRepository stockRepository;


    @Override
    public Stock Save(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock getStock(long id) {
        return stockRepository.findById(id).get();
    }


    @Override
    public Map<String, Boolean> deleteStock(long id) {
        stockRepository.deleteById(id);
        Map<String, Boolean> res = new HashMap<>();
        res.put("deleted", Boolean.TRUE);
        return res;
    }

    @Override
    public Stock updateStock(long id, Stock stock) {
        Stock old = getStock(id);
        old.setQuantityMin(stock.getQuantityMin());
        old.setQuantityProd(stock.getQuantityProd());
        old.setCode(stock.getCode());
        return stockRepository.save(old);
    }

    @Override
    public List<Stock> findBycode(String code) {
        return stockRepository.findBycode(code);
    }
}
