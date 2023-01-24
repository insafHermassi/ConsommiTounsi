package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.Product;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;
import com.S2t.ConsommiTounsi.repository.ProductRepository;
import com.S2t.ConsommiTounsi.service.FileService;
import com.S2t.ConsommiTounsi.service.ProductService;

import jdk.jfr.Category;
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
    FileService fileService;

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) throws RessourcesNotFound {
        return productRepository.findById(id).orElseThrow(()-> new RessourcesNotFound ("product not found for id :"+id));

    }

    @Override
    public Product saveProduct(Product product, MultipartFile file) throws IOException {
        String fileName = fileService.uploadImage(file);
        product.setImage(fileName);
        return productRepository.save(product);
    }

    @Override
    public Map<String, Boolean> deleteProduct(long id) throws IOException, RessourcesNotFound {

        log.info("delete product with id : {}",id);

        Product product = productRepository.findById(id).orElseThrow(
                () -> new RessourcesNotFound("Product not found for id : "+id));
        productRepository.delete(product);
        fileService.deleteImage(product.getImage());
        Map<String,Boolean> res= new HashMap<>();
        res.put("deleted",Boolean.TRUE);
        return res;
    }


    @Override
    public Product updateProduct(long id, Product product, MultipartFile file) throws IOException, RessourcesNotFound {
        Product p = getProduct(id);
        p.setName(product.getName());
        p.setRef(product.getRef());
        p.setPrice(product.getPrice());
        p.setDescription(product.getDescription());
        p.setTva(product.getTva());
        p.setQuantity(product.getQuantity());

        //delete image
        fileService.deleteImage(p.getImage());

        //save new image
        String fileName = fileService.uploadImage(file);
        p.setImage(fileName);
        return productRepository.save(p);
    }

    @Override
    public List<Product> searchProductByName(String firstname) throws RessourcesNotFound {
        return productRepository.findByname(firstname) ;
    }


    @Override
    public List<Product> searchByCategory(Category category) throws RessourcesNotFound {
        return productRepository.findByCategory( category);
    }

    @Override
    public Product Save(Product product, MultipartFile image) {
        return productRepository.save(product);
    }
}