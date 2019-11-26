package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.service.MemberService;
import com.aaa.lee.app.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Lee
 * @Date Create in 2019/11/21 9:36
 * @Description
 **/
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private RedisService redisService;

    /**
     * @author Lee
     * @description
     *      执行登录操作
     * @param
     * @date 2019/11/21
     * @return java.lang.Boolean
     * @throws 
    **/
    @PostMapping("/login")
    public Boolean doLogin(@RequestParam(value = "openId") String openId) {
        return memberService.doLogin(openId, redisService);
    }

}
