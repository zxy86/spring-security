package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Classname SpringSecurityApplication
 * @Date 2021/7/16 9:04
 * @Created by GAEA
 */
@SpringBootApplication
@MapperScan("com.itheima.mapper")
public class SpringSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }
}
