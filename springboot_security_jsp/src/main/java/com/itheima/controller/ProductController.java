package com.itheima.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname ProductController
 * @Date 2021/7/16 9:05
 * @Created by GAEA
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Secured("ROLE_PRODUCT")
    @RequestMapping("/findAll")
    public String findAll(){
        return "product-list";
    }
}
