package com.haoran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

    //这里运行报错404的话，从maven开始运行。
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
