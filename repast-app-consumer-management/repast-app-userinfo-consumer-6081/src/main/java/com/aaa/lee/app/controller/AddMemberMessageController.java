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
 * @ClassName AddMemberMessageController
 * @Author li
 * @Date 2019/11/26
 * @Version 1.0
 **/
@RestController
@Api(value = "添加用户信息",tags = "添加用户信息")
public class AddMemberMessageController extends BaseController {

    @Autowired
    private IRepastService repastService;

    @PostMapping("/addMessage")
    @ApiOperation(value = "添加信息",tags = "添加用户信息")
    public ResultData AddMemberMessage(Member member){
        int i = repastService.addMemberMessages(member);
        if(i>0){
            return success();
        }else{
            return failed();
        }
    }


}
