package com.aaa.lee.app.controller;

import com.aaa.lee.app.service.DoProductCollectService;
import com.aaa.lee.app.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @param
 * @ClassName DoProductCollectController
 * @Author li
 * @Date 2019/11/23
 * @Version 1.0
 **/
@RestController
public class DoProductCollectController {

    @Autowired
    private DoProductCollectService doProductCollectService;

    @Autowired
    private RedisService redisService;

    /**
     * 购买商品执行添加收藏信息
     * @param shopId
     * @param openId
     * @return
     */
    @PostMapping("/pCollect")
    public Boolean productCollects(@RequestParam(value = "shopId") Long shopId, @RequestParam(value = "openId") String openId){

        return doProductCollectService.DoProductCollect(shopId,openId,redisService);

    };
}
