package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.Product;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;

import jdk.jfr.Category;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProduct(long id) throws RessourcesNotFound;
    public Product saveProduct(Product product, MultipartFile file) throws IOException;

    public Map<String,Boolean> deleteProduct(long id) throws RessourcesNotFound, IOException;
    public Product updateProduct(long id ,Product product,MultipartFile file) throws RessourcesNotFound, IOException;
    public List<Product> searchProductByName(String firstname)throws RessourcesNotFound;

    List<Product>  searchByCategory(Category category) throws RessourcesNotFound;

    Product Save(Product product, MultipartFile image) ;
}