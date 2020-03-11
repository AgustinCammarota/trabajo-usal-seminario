package com.bolsadeideas.springboot.app.models.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadFileServiceImpl implements IUploadFileService {
    private static String FILE_NAME = "uploads";

    @Override
    public String copy(MultipartFile foto) throws IOException {
        //Para el nombre del archivo siempre sea unico
        String uniqueFileName = UUID.randomUUID().toString() + "_" + foto.getOriginalFilename();
        Path rootPathAbsolute = getPath(uniqueFileName).toAbsolutePath();
        Files.copy(foto.getInputStream(), rootPathAbsolute);

        return uniqueFileName;
    }

    @Override
    public boolean delete(String filename) {
        Path rootPath = getPath(filename);
        File archivo = rootPath.toFile();

        if (archivo.exists() && archivo.canRead()) {
            if (archivo.delete()) {
                return true;
            }
        }
        return false;
    }

    public Path getPath(String filename) {
        return Paths.get(FILE_NAME).resolve(filename).toAbsolutePath();
    }
}
