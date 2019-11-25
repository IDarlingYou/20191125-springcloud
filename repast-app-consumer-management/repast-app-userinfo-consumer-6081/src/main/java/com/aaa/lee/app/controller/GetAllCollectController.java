package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @param
 * @ClassName GetAllCollectController
 * @Author li
 * @Date 2019/11/24
 * @Version 1.0
 **/
@RestController
@Api(value = "商品收藏列表",tags = "获取所有收藏商品列表")
public class GetAllCollectController extends BaseController {

    @Autowired
    private IRepastService repastService;

    @PostMapping("/getAllCollect")
    @ApiOperation(value = "订单商品收藏", notes = "下订单时点击收藏")
    public ResultData getAllCollects(String openId) {
        List<Product> a = repastService.getAllCollects(openId);
        if(a.size()>0){
            return success(a);
        }else {
            return failed();
        }
    }


}
