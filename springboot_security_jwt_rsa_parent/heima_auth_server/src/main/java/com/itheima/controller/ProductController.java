package com.itheima.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname ProductController
 * @Date 2021/7/16 9:05
 * @Created by GAEA
 */
@RestController
@RequestMapping("/product")
public class ProductController {

//    @Secured("ROLE_PRODUCT")
    @RequestMapping("/findAll")
    public String findAll(){
        return "产品列表查询成功！";
    }
}
