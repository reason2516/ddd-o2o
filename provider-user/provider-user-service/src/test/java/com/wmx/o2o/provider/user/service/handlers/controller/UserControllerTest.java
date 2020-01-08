package com.wmx.o2o.provider.user.service.handlers.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGet() throws Exception {
        MockHttpServletResponse id = mockMvc.perform(MockMvcRequestBuilders.get("/user/getUser").param("id", "UID157244023345452813"))
                .andReturn()
                .getResponse();
        String contentAsString = id.getContentAsString();
        System.out.println(contentAsString);
    }
}