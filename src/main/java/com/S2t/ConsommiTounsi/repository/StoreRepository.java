package com.S2t.ConsommiTounsi.repository;

import com.S2t.ConsommiTounsi.entities.Category;
import com.S2t.ConsommiTounsi.entities.Store;
import com.S2t.ConsommiTounsi.entities.TypeRay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {
    public List<Store>findByCategory(Category category);
    public List<Store> findByTypeRay(TypeRay typeRay);
}
