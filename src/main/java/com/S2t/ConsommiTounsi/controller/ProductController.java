package com.S2t.ConsommiTounsi.controller;
import com.S2t.ConsommiTounsi.entities.Category;
import com.S2t.ConsommiTounsi.entities.Product;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;
import com.S2t.ConsommiTounsi.repository.ProductRepository;
import com.S2t.ConsommiTounsi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;
import java.util.Map;
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/products")
public class ProductController extends  BasicController {
    @Autowired
    ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/welcome")
    public String welcome(){
        return "welcome, i'am a robot. I will help you to manage product";
    }


    @PostMapping (consumes = "multipart/form-data")
    public Product SaveProduct(@RequestParam("name") String name,
                               @RequestParam("reference") String reference,
                               @RequestParam("price") double price ,
                               @RequestParam("category") Category category ,
                               @RequestParam("CodeBarre") String CodeBarre,
                               @RequestParam("quantity") double quantity,
                               @RequestParam("tva") double tva,
                               @RequestParam ("image")  MultipartFile image) throws   IOException {

        Product product = new Product();

        product.setName(name);
        product.setReference(reference);
        product.setCategory(category);
        product.setPrice(price);
        product.setCodeBarre(CodeBarre);
        product.setQuantity(quantity);
        product.setTva(tva);

        return productService.Save(product,image);
    }

    @GetMapping
    public List<Product> getProduct() {
        return productService.getProduct();
    }

    @GetMapping(value = "/{id}")

    public Product getProduct(@PathVariable("id")long id)  {
        return productService.getProduct(id);
    }

    @DeleteMapping
    public Map<String,Boolean> deleteProduct(@RequestParam("id") long id)throws IOException, RessourcesNotFound {
        return productService.deleteProduct(id);
    }


    @PutMapping(consumes = "multipart/form-data")
    public  Product updateProduct(@RequestParam("id") Long id ,
                                  @RequestParam("name") String name,
                                  @RequestParam("reference") String reference,
                                  @RequestParam("price") double price ,
                                  @RequestParam("codeBarre") String codeBarre ,
                                  @RequestParam("quantity") double quantity,
                                  @RequestParam("category")Category category,
                                  @RequestParam("tva")double tva,
                                  @RequestParam ("image")  MultipartFile image) throws RessourcesNotFound,
            IOException {

        Product product = new Product();

        product.setName(name);
        product.setReference(reference);
        product.setPrice(price);
        product.setCodeBarre(codeBarre);
        product.setQuantity(quantity);
        product.setCategory(category);
        product.setTva(tva);

        return productService.updateProduct(id,product,image);
    }

    @GetMapping(value = "/find")
    public  List<Product> getByCategory(@RequestParam("category") Category category){
        return productService.searchByCategory(category);
    }


}
