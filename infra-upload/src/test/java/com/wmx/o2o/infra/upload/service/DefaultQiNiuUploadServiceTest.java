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
    private DefaultQiNiuUploadService qiNiuUploadService;

    @Test
    public void testUpToken() {
        qiNiuUploadService.upToken();
    }

    @Test
    public void testUploadFile() {
        File file = new File("/Users/xingshulin/Desktop/test.png");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
        String date = sdf.format(new Date());

        String newFileName = System.currentTimeMillis() + file.getPath().substring(file.getPath().lastIndexOf("."));

        String key = date + "/" + newFileName;
        String s = qiNiuUploadService.uploadFile(file, key);
        System.out.println(s);
    }
}
