package cn.com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wx
 * @version 1.0
 * @date 2021/1/22 12:36
 */
@RestController
@Slf4j
public class TestController {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello security";
    }


    @GetMapping(value = "/update")
    @Secured({"ROLE_sale","ROLE_manager"})
    public String update(){
        return "hello update";
    }
}
