package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.library.dao")
@EnableEurekaClient
public class FileuploadMain18001 {
    public static void main(String[] args) {
        SpringApplication.run(FileuploadMain18001.class,args);
    }
}
