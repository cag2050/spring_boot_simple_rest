package com.cag.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;

@RestController
public class JacksonDemo {

    @RequestMapping(value = {"/jackson"}, method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=UTF-8")
    public String jackson(
            @RequestParam String param1,
            @RequestParam(name = "param2_data", required = false) String param2Data,
            @RequestParam(defaultValue = "default_value") String param3) throws JsonProcessingException {
        System.out.println(param1);
        System.out.println(param2Data);
        System.out.println(param3);
        HashMap<String, String> paramsMap = new LinkedHashMap<>();
        paramsMap.put("param1", param1);
        paramsMap.put("param2", param2Data);
        paramsMap.put("param3", param3);
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(paramsMap);
        return str;
    }
}
