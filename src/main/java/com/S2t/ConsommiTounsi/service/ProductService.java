package com.S2t.ConsommiTounsi.service;
import com.S2t.ConsommiTounsi.entities.Category;
import com.S2t.ConsommiTounsi.entities.Product;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ProductService {
    public Product Save(Product product, MultipartFile file) throws IOException;

    public Product getProduct(long id);

    public List<Product> getProduct();

    public Map<String, Boolean> deleteProduct(long id) throws IOException, RessourcesNotFound;

    public Product updateProduct(long id, Product product, MultipartFile file )throws IOException, RessourcesNotFound;

    public List<Product> searchByname(String name);


    public List<Product> searchByCategory(Category category);
}