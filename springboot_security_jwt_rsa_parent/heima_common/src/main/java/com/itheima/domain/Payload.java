package com.itheima.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Classname Payload
 * @Date 2021/7/16 16:25
 * @Created by GAEA
 */
@Data
public class Payload<T> {
    private String id;
    private T userInfo;
    private Date expiration;
}
