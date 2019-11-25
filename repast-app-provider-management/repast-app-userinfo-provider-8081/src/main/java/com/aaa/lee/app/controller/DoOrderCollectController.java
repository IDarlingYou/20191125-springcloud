package com.aaa.lee.app.controller;

import com.aaa.lee.app.service.DoOrderCollectService;
import com.aaa.lee.app.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @param
 * @ClassName DoOrderCollectController
 * @Author li
 * @Date 2019/11/23
 * @Version 1.0
 **/
@RestController
public class DoOrderCollectController {

    @Autowired
    private DoOrderCollectService doOrderCollectService;

    @Autowired
    private RedisService redisService;

    @PostMapping("/oCollect")
    public Boolean orderCollects(@RequestParam(value = "orderId") Long orderId, @RequestParam(value = "openId") String openId){
        return doOrderCollectService.orderCollectss(orderId, openId, redisService);

    };

}
