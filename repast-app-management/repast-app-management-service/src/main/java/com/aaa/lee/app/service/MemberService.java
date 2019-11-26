package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.mapper.MemberMapper;
import com.aaa.lee.app.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import static com.aaa.lee.app.staticstatus.StaticProperties.*;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/21 9:37
 * @Description
 **/
@Service
public class MemberService extends BaseService<Member> {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Mapper<Member> getMapper() {
        return memberMapper;
    }


    /**
     * @author Seven Lee
     * @description
     *      执行登录操作
     * @param , redisService]
     * @date 2019/11/21
     * @return java.lang.Boolean
     * @throws    **/
    public Boolean doLogin(String openId, RedisService redisService) {
        try {
            Member mbr = memberMapper.selectByOpenId(openId);

            if(null != mbr) {
                // 说明从数据库中查询到数据，说明登录成功
                // 应该把用户对象存入session中，session跨域了，就使用redis解决(redis也有问题)
                mbr.setPassword(null);
                String mbrString = JSONUtil.toJsonString(mbr);
                String setResult = redisService.set(REDIS_KEY, mbrString);
                if(OK.equals(setResult.toUpperCase())) {
                    // 说明redis存入成功
                    return true;
                }
            }else{
                int i = memberMapper.insertMemberMessage(openId);
                if(i>0){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
