package com.cag.controller;

import com.cag.controller.exception_handler.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionDemo {

    @RequestMapping(value = "/exception", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=UTF-8")
    public String exception() throws MyException {
        throw new MyException("发生错误");
//        return "{\"key\": \"exception\"}";
    }
}
