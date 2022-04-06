package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Slf4j
@Controller
public class FormController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "/form/form_layouts";
    }

    @PostMapping("uploadImage")
    public String uploadImage(@RequestPart("image") MultipartFile image,
                              @RequestPart("images") MultipartFile[] images,
                              @RequestParam("email") String email,
                              @RequestParam("username") String username) throws IOException {
        log.info("邮箱地址:{},用户名：{}",email,username);
        log.info("image大小：{}，images的多少：{}",image.getSize(),images.length);
        String basePath="D:\\IDEA_project\\SpringBoot_Web_admin\\resources\\";
        if(!image.isEmpty()){
            String originalFilename = image.getOriginalFilename();
            File file1 = new File(basePath+ originalFilename);
            image.transferTo(file1);
        }
        if(images.length > 0) {
            for (MultipartFile baseImg : images) {
                if (!baseImg.isEmpty()) {
                    String originalFilename = baseImg.getOriginalFilename();
                    File file2 = new File(basePath + originalFilename);
                    baseImg.transferTo(file2);
                }
            }
        }

        return "main";
    }

}
