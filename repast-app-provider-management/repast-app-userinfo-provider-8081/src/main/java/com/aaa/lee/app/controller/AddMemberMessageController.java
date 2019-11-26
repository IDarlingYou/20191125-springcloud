package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.service.AddMemberMessageService;
import com.aaa.lee.app.service.MemberService;
import com.aaa.lee.app.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @param
 * @ClassName AddMemberMessageController
 * @Author li
 * @Date 2019/11/26
 * @Version 1.0
 **/
@RestController
public class AddMemberMessageController {
    
    @Autowired
    private AddMemberMessageService addService;

    @Autowired
    private RedisService redisService;

    @PostMapping("/addMessage")
    public int addMemberMessages(@RequestBody Member member){
        return  addService.addMemberMessages(member,redisService);

    };
}
