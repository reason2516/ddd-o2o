package com.wmx.o2o.infra.upload.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultQiNiuUploadServiceTest {

    @Autowired
    private DefaultQiNiuUploadService defaultQiNiuUploadService;

    @Test
    public void testUpToken() {
        defaultQiNiuUploadService.upToken();
    }

    @Test
    public void testUploadFile() {
        // 图片旋转
        // DEMO http://wmx-images.enkeedu.com/2020/25/05/1583418320298.png?imageMogr2/rotate/0
        // 文档 https://developer.qiniu.com/dora/api/1270/the-advanced-treatment-of-images-imagemogr2#5
        File file = new File("/Users/wangmingxu/Desktop/test.png");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
        String date = sdf.format(new Date());

        String newFileName = System.currentTimeMillis() + file.getPath().substring(file.getPath().lastIndexOf("."));

        String key = date + "/" + newFileName;
        String s = defaultQiNiuUploadService.uploadFile(file, key);
        System.out.println(s);
    }
}

