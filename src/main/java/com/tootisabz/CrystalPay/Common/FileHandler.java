package com.tootisabz.CrystalPay.Common;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileHandler {
    @Value("${upload.directory:uploads}")
    private String UPLOAD_DIR;
    public String FileUpload(MultipartFile file) {

        try {
            // Create the upload directory relative to the application's running directory
            Path uploadPath = Paths.get(System.getProperty("user.dir"), UPLOAD_DIR);

            // Create the upload directory if it doesn't exist
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Save the file
            Path filePath = uploadPath.resolve(file.getOriginalFilename());
            file.transferTo(filePath.toFile());
            return filePath.toString();
        } catch (IOException e) {
            return ("Could not upload file: " + e.getMessage());
        }
    }
}
