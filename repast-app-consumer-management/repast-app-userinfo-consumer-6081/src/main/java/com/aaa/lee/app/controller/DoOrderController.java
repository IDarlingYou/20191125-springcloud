package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @param
 * @ClassName DoOrderController
 * @Author li
 * @Date 2019/11/23
 * @Version 1.0
 **/
@RestController
@Api(value = "订单收藏", tags = "订单信息收藏")
public class DoOrderController extends BaseController {

    @Autowired
    private IRepastService repastService;

    @PostMapping("/oCollect")
    @ApiOperation(value = "订单商品收藏", notes = "下订单时点击收藏")
    public ResultData orderCollects(Long orderId,String openId) {
        Boolean a = repastService.orderCollects(orderId, openId);

        if(a == true){
            return success();
        }else {
            return failed();
        }
    }

}
