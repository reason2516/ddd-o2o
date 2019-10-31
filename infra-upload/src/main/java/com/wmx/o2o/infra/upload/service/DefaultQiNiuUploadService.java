package com.wmx.o2o.infra.upload.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class DefaultQiNiuUploadService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${qiniu.config.accesskey}")
    private String accessKey;

    @Value("${qiniu.config.secretkey}")
    private String secretKey;

    @Value("${qiniu.config.bucket}")
    private String bucket;

    @Value("${qiniu.config.domain}")
    private String domain;

    @Autowired
    private ObjectMapper objectMapper;

    public String upToken() {
        return Auth.create(accessKey, secretKey).uploadToken(bucket);
    }

    public String uploadFile(File file, String key) {
        Configuration conf = new Configuration(Region.region1());
        UploadManager manager = new UploadManager(conf);

        String token = upToken();
        String url = "";

        try {
            Response resp = manager.put(file, key, token);
            DefaultPutRet putRet = objectMapper.readValue(resp.bodyString(), DefaultPutRet.class);
            url = domain +"/"+ putRet.key;
        } catch (QiniuException e) {
            e.printStackTrace();
            logger.error("[七牛上传异常]", e);
            throw new RuntimeException("[七牛上传异常：]", e);
        } catch (JsonParseException e) {
            e.printStackTrace();
            logger.error("[七牛上传异常]", e);
            throw new RuntimeException("[七牛上传返回值解析异常：]", e);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("[七牛上传异常]", e);
            throw new RuntimeException("[七牛上传返回值解析IO异常：]", e);
        }

        return url;
    }
}
