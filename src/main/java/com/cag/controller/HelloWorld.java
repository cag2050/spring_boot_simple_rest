package com.cag.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping(value = {"/", "/hello"}, method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json; charset=UTF-8"})
    public String helloWorld() {
        return "{\"word999\":\"hello world\"}";
    }
}
