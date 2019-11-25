package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.service.GetAllCollectsService;
import com.aaa.lee.app.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @param
 * @ClassName GetAllCollectsController
 * @Author li
 * @Date 2019/11/24
 * @Version 1.0
 **/
@RestController
public class GetAllCollectsController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private GetAllCollectsService getAllCollects;

    @PostMapping("/getAllCollect")
    public List<Product> getAllCollects(@RequestParam(value = "openId") String openId){

       return getAllCollects.GetAllCollects(openId);


    };


}
