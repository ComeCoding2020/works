package com.blog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试用的controller类
 */
@Controller
public class UserController {

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "/user/getAll", method = RequestMethod.POST)
    @ResponseBody
    private String getAllUsers(TestParams params) throws JsonProcessingException {
        return objectMapper.writeValueAsString(params);
    }

}
