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
            @RequestParam(defaultValue = "default_value") String param3) {
        Long startTime = System.currentTimeMillis();

        HashMap<String, String> paramsMap = new LinkedHashMap<>();
        paramsMap.put("param1", param1);
        paramsMap.put("param2", param2Data);
        paramsMap.put("param3", param3);

        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("key1","value1");

        HashMap allMap = new HashMap();
        allMap.put("params", paramsMap);
        allMap.put("data", dataMap);
        allMap.put("status", "success");
        Long elasped = System.currentTimeMillis() - startTime;
        allMap.put("elasped", elasped + "ms");

        ObjectMapper mapper = new ObjectMapper();
        String returnStr = null;
        try {
            returnStr = mapper.writeValueAsString(allMap);
        } catch (JsonProcessingException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return returnStr;
    }
}
