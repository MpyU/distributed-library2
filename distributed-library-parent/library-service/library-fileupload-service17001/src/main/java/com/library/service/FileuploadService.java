package com.library.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileuploadService {

    String upload(MultipartFile file) throws Exception;
}
