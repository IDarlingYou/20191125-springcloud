package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.Member;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MemberMapper extends Mapper<Member> {

    /**
     * 用户登陆微信，从数据库获取信息
     * @param openId
     * @return
     */
    Member selectByOpenId(String openId);

    /**
     * 用户第一次登陆微信，在数据库存入openid
     * @param openId
     * @return
     */
    int insertMemberMessage(String openId);

}