package com.bolsadeideas.springboot.app.models.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IUploadFileService {

    String copy(MultipartFile foto) throws IOException;

    boolean delete(String filename);

}
