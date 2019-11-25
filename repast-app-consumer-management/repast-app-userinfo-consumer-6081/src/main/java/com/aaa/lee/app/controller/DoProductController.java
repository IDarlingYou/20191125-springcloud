package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @param
 * @ClassName ProductCollect
 * @Author li
 * @Date 2019/11/23
 * @Version 1.0
 **/
@RestController
@Api(value = "商品收藏", tags = "商品信息收藏")
public class DoProductController extends BaseController {

    @Autowired
    private IRepastService repastService;

    @PostMapping("/pCollect")
    @ApiOperation(value = "商品收藏", notes = "浏览商品信息时点击收藏")
    public ResultData productCollects(Long shopId,String openId) {
        Boolean a = repastService.productCollects(shopId, openId);
        if(a == true){
            return success();
        }else {
            return failed();
        }
    }



}
