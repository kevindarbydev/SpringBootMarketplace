package com.kevin.mp2;
import java.io.*;
import java.nio.file.*;
 
import org.springframework.web.multipart.MultipartFile;
 
public class FileUploadUtil {
     
    public static void saveFile(String uploadDir, String fileName,
        MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
         
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
            System.out.println("Directory created!");
        }
         
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Saved file successfully!");
        } catch (IOException ioe) {        
            throw new IOException("Could not save image file: " + fileName, ioe);
        }      
    }
}