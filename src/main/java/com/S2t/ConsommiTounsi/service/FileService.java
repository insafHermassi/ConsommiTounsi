package com.S2t.ConsommiTounsi.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface FileService {
    String uploadImage( MultipartFile file ) throws IOException;
    InputStream getResource(String path, String fileName) throws FileNotFoundException;
    void deleteImage(String fileName) throws IOException;
}
