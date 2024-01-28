package com.shawn.controller;

import com.aliyuncs.exceptions.ClientException;
import com.shawn.pojo.Result;
import com.shawn.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/*
在SpringBoot中，文件上传，默认单个文件允许最大大小为1M，如果需要上传大文件，可以进行如下配置

存在问题：浏览器无法直接访问到，前端页面无法直接访问
 */
@RestController
@Slf4j
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;
    // 本地存储文件
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
//        log.info("文件上传：{}, {}, {}", username, age, image);
//        // 获取原始文件名
//        String originalFilename = image.getOriginalFilename();
//
//        // 构造唯一的文件名 -- uuid(通用唯一识别码) 29c63b6a-ae06-4121-9b34-2dfee6b1c2b3.jpg
////        int index = originalFilename.lastIndexOf(".");
////        String extname = originalFilename.substring(index);
////        String newFileName = UUID.randomUUID() + extname;
//        String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
//        log.info("新的文件名: {}", newFileName);
//
//        // 将文件存储在服务器的磁盘目录中
//        image.transferTo(new File("D:\\下载\\文件上传\\" + newFileName));
//        return Result.success();
//    }

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException, ClientException {
        log.info("文件上传，文件名：{}", image.getOriginalFilename());
        // 调用阿里云OSS工具类进行文件上传
        String url = aliOSSUtils.upload(image);
        // 输出日志便于排查问题
        log.info("文件上传完成，文件访问的url：{}", url);

        return Result.success(url);
    }
}
