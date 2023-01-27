package com.S2t.ConsommiTounsi.repository;
import com.S2t.ConsommiTounsi.entities.Category;
import com.S2t.ConsommiTounsi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository <Product,Long> {
   public List<Product> findByname (String name);

   public List<Product> findByCategory(Category category);

}