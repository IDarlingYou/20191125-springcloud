package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.mapper.MemberMapper;
import com.aaa.lee.app.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import static com.aaa.lee.app.staticstatus.StaticProperties.OK;
import static com.aaa.lee.app.staticstatus.StaticProperties.REDIS_KEY;

/**
 * @param
 * @ClassName AddMemberMessageService
 * @Author li
 * @Date 2019/11/26
 * @Version 1.0
 **/
@Service
public class AddMemberMessageService extends BaseService<Member> {

    @Autowired
    private MemberMapper memberMapper;


    @Override
    public Mapper<Member> getMapper() {
        return null;
    }

    public int addMemberMessages(Member member,RedisService redisService){
        int i = memberMapper.insert(member);
        if(i>0){
            String member1 = JSONUtil.toJsonString("member");
            String set = redisService.set(REDIS_KEY, member1);
           return i;
        }
            return 0;
    }

}
