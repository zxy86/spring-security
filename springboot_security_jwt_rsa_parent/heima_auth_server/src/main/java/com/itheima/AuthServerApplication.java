package com.itheima;

import com.itheima.config.RsaKeyProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Classname AuthServerApplication
 * @Date 2021/7/19 8:57
 * @Created by GAEA
 */
@SpringBootApplication
@MapperScan("com.itheima.mapper")
@EnableConfigurationProperties(RsaKeyProperties.class)
public class AuthServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }
}
