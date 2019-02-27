package com.haoran;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: lihaoran
 * Date: 2019/2/27
 * Time: 9:56
 * Description:
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }
}