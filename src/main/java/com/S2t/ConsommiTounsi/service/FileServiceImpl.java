package com.S2t.ConsommiTounsi.service;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
@Service
public class FileServiceImpl implements FileService{
    @Value("${project.image}")
    private String path;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {

        //File name
        String name = file.getOriginalFilename();
        //log.info(name);

        //random name generate file
        String randomID = UUID.randomUUID().toString();
        String fileName1= randomID.concat(name.substring(name.lastIndexOf(".")));

        //Fullpath
        String filePath = path + File.separator +fileName1;

        //create folder if not created
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }
        //file copy
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileName1;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path+ File.separator +fileName;
        InputStream is = new FileInputStream(fullPath);
        //db logic to return inputStream
        return is;
    }

    @Override
    public void deleteImage(String fileName) throws IOException {
        String fullPath = path+ File.separator +fileName;
        Files.delete(Paths.get(fullPath));
    }
}
