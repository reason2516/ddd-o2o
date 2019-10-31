package com.wmx.o2o.infra.upload.controller;

import com.wmx.o2o.infra.upload.service.DefaultQiNiuUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qiniu")
public class QiNiuUploadController {

    @Autowired
    private DefaultQiNiuUploadService qiNiuUploadService;

    @GetMapping("/upToken")
    public String upToken(){
        return qiNiuUploadService.upToken();
    }

}
