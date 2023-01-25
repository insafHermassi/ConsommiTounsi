package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.Category;
import com.S2t.ConsommiTounsi.entities.Store;
import com.S2t.ConsommiTounsi.entities.TypeRay;

import java.util.List;
import java.util.Map;

public interface StoreService {
    public Store Save(Store store);

    public Store getStore(long id);

    public List<Store> getStore();


    public Map<String, Boolean> deleteStore(long id);

    public Store updateStore(long id, Store store);

    public List<Store> findBytypeRay(TypeRay typeRay);

    public List<Store> searchByCategory(Category category);

}
