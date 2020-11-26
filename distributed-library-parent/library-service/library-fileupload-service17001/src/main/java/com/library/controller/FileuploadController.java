package com.library.controller;

import com.library.pojo.Result;
import com.library.pojo.ResultCode;
import com.library.service.FileuploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileuploadController {

    @Autowired
    private FileuploadService fileuploadService;

    @PostMapping("/upload")
    public Result<String> upload(@RequestParam("filename") MultipartFile file) throws Exception {
        String upload = fileuploadService.upload(file);
        return new Result(ResultCode.FAIL,"上传成功！",upload);
    }
}
