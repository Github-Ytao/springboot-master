package com.tao.project.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author YangTao
 * @date 2021-11-14 18:53
 */
@Controller
public class UploadController {

    @Value("${file.upload.path}")
    private String path;

    @RequestMapping("/page")
    public String uploadPage() {
        return "upload";
    }

    /**
     * 单个文件上传
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    @ResponseBody
    public String create(@RequestPart MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = path + fileName;

        File dest = new File(filePath);
        Files.copy(file.getInputStream(), dest.toPath());
        return "Upload file success : " + dest.getAbsolutePath();
    }

    /**
     * 多文件上传
     * @param files
     * @return
     * @throws IOException
     */
    @PostMapping("/mult/upload")
    @ResponseBody
    public String create(@RequestPart MultipartFile[] files) throws IOException {
        StringBuffer message = new StringBuffer();

        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            String filePath = path + fileName;

            File dest = new File(filePath);
            Files.copy(file.getInputStream(), dest.toPath());
            message.append("Upload file success : " + dest.getAbsolutePath()).append("<br>");
        }
        return message.toString();
    }
}
