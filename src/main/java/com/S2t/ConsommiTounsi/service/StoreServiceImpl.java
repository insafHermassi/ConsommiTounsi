package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.Category;
import com.S2t.ConsommiTounsi.entities.Store;
import com.S2t.ConsommiTounsi.entities.TypeRay;
import com.S2t.ConsommiTounsi.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreRepository storeRepository;
    @Override
    public Store Save(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Store getStore(long id) {
        return storeRepository.findById(id).get();
    }

    @Override
    public List<Store> getStore() {
        return storeRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteStore(long id) {
        storeRepository.deleteById(id);
        Map<String,Boolean>res=new HashMap<>();
        res.put("deleted",Boolean.TRUE);
        return res;
    }

    @Override
    public Store updateStore(long id, Store store) {
        Store old=getStore(id);
        old.setCategory(store.getCategory());
        old.setTypeRay(store.getTypeRay());
        return storeRepository.save(old);
    }

    @Override
    public List<Store> findBytypeRay(TypeRay typeRay) {
        return storeRepository.findByTypeRay(typeRay);
    }

    @Override
    public List<Store> searchByCategory(Category category) {
        return storeRepository.findByCategory(category);
    }
}
