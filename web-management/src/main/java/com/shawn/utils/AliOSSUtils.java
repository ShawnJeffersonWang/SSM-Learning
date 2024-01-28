package com.shawn.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 阿里云OSS工具类
 */
@Component
public class AliOSSUtils {

    String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
    String bucketName = "web-sh-ti";

    /**
     * 实现上传图片到OSS
     * upload不是静态方法,要想调用工具类中的方法就得new对象,而spring环境下不建议new对象
     * 所以直接交给容器管理
     */
    public String upload(MultipartFile file) throws IOException, ClientException {
        // 获取上传的文件的输入流
        EnvironmentVariableCredentialsProvider credentialsProvider =
                CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        InputStream inputStream = file.getInputStream();

        // 避免文件覆盖
        String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        String fileName = UUID.randomUUID().toString() +
                originalFilename.substring(originalFilename.lastIndexOf("."));

        // 上传文件到OSS
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);
        ossClient.putObject(bucketName, fileName, inputStream);

        // 文件访问路径
        String url = endpoint.split("//")[0] + "//" + bucketName + "." +
                endpoint.split("//")[1] + "/" + fileName;
        ossClient.shutdown();
        // 把上传到oss的路径返回
        return url;
    }
}
