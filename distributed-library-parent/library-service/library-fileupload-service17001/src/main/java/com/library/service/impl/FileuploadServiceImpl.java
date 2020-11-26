package com.library.service.impl;

import com.library.service.FileuploadService;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileuploadServiceImpl implements FileuploadService {

    @Autowired
    private TrackerClient trackerClient;

    @Override
    public String upload(MultipartFile file) throws Exception {
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer,null);
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
        String[] strings = storageClient.upload_file(file.getBytes(), extName, null);
        System.out.println(strings[0]+"------"+strings[1]);
        return "http://119.29.172.177:17001/"+strings[0]+"/"+strings[1];
    }
}
