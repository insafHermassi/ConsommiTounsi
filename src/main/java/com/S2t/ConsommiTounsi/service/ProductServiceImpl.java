package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.Category;
import com.S2t.ConsommiTounsi.entities.Product;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;
import com.S2t.ConsommiTounsi.repository.ProductRepository;
import com.S2t.ConsommiTounsi.service.FileService;
import com.S2t.ConsommiTounsi.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    ProductRepository productRepository;
    @Autowired
    FileService fileService;

    @Override
    public Product Save(Product product, MultipartFile file) throws IOException {
        String fileName = fileService.uploadImage(file);
        product.setImage(fileName);
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteProduct(long id) throws IOException, RessourcesNotFound {

        Product product = productRepository.findById(id).orElseThrow(
                () -> new RessourcesNotFound("Product not found for id : "+id));
        productRepository.delete(product);
        fileService.deleteImage(product.getImage());
        Map<String,Boolean> res= new HashMap<>();
        res.put("deleted",Boolean.TRUE);
        return res;
    }

    @Override
    public Product updateProduct(long id, Product product,  MultipartFile file) {

        Product old = getProduct(id);
        old.setName(product.getName());
        old.setPrice(product.getPrice());
        old.setReference(product.getReference());
        old.setCategory(product.getCategory());
        old.setQuantity(product.getQuantity());
        old.setCodeBarre(product.getCodeBarre());
        old.setTva(product.getTva());


        return productRepository.save(old);
    }

    @Override
    public List<Product> searchByname(String name) {
        return productRepository.findByname(name);
    }

    @Override
    public List<Product> searchByCategory(Category category) {
        return productRepository.findByCategory(category);
    }
}