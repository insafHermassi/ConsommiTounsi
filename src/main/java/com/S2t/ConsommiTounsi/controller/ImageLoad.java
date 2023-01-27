package com.S2t.ConsommiTounsi.controller;
import com.S2t.ConsommiTounsi.entities.Product;
import com.S2t.ConsommiTounsi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import javax.activation.FileTypeMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/images")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ImageLoad {
    @Autowired
    ProductRepository productRepository;

    @GetMapping(path = "/get/{url}", produces = MediaType.IMAGE_PNG_VALUE)

    public byte[] getPhoto(@PathVariable("url")long id)
            throws IOException{
        Product product= productRepository.findById(id).get();
        return
                Files.readAllBytes(Paths.get("C:\\Documents\\images"+product.getImageName()));

    }
}

