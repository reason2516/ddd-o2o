//package com.wmx.o2o.api.customer.service.Identity.impl;
//
//import com.wmx.o2o.api.customer.service.Identity.IdentityUserService;
//import com.wmx.o2o.api.customer.service.Identity.dto.UserDO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
////@Service
//public class IdentityUserServiceImpl implements IdentityUserService {
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Override
//    public UserDO get(Long id) {
//        return this.restTemplate.getForObject("http://SERV-IDENTITY/user/get?id=" + id, UserDO.class);
//    }
//}
