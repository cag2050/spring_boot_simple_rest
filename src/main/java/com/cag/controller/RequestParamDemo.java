package com.cag.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParamDemo {

    //    请求地址：http://localhost:8080/requestparam?param1=111&param2_data=222&param3=
    @RequestMapping(value = "/requestparam", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=UTF-8")

//    如果前端传递的参数和后端你接受的参数起的名字字段是一致的可以省略不写，也可以直接写@RequestParam String title,如果不一致一定要完整写，不然获取不到
//    默认 required = true
//    required = true 的参数，设置默认值后，可以不传
    public String requestParam(
            @RequestParam String param1,
            @RequestParam(name = "param2_data", required = false) String param2Data,
            @RequestParam(defaultValue = "default_value") String param3) {
        System.out.println("param1 = " + param1);
        System.out.println("param2_data = " + param2Data);
        System.out.println("param3" + param3);
        return "{\"param1\":\"" + param1 + "\",\"param2\":\"" + param2Data + "\",\"param3\":\"" + param3 + "\"}";
    }
}
