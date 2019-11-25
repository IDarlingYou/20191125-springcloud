package com.aaa.lee.app.service;

import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.MemberReceiveAddress;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.domain.ProductCat;
import com.aaa.lee.app.fallback.RepastFallBackFactory;
import com.aaa.lee.app.vo.ShopInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/20 11:40
 * @Description
 *      当使用feign进行传参的时候，如果是对象,包装类型,实体类...必须要使用@RequestBody，并且这个@RequestBody只能在该方法中出现一次
 *          ResultData selectUsersCondition(@RequestBody User user, @RequestBody UserInfo userInfo);---->错误
 *      当传递的参数是简单类型(String, Integer....8种基本类型+String)，必须要使用@RequestParam("")，这个@RequestPara注解可以出现多个
 *          ResultData selectUsersCondition(@RquestPara("username") String username, @RequestParam("age") Integer age);---->正确
 *
 **/
@FeignClient(value = "userinfo-interface-provider", fallbackFactory = RepastFallBackFactory.class)
public interface IRepastService {

    /**
     * 填写订单的时候执行收藏操作
     * @param orderId
     * @param openId
     * @return
     */
    @PostMapping("/oCollect")
    Boolean orderCollects(@RequestParam(value = "orderId") Long orderId,@RequestParam(value = "openId") String openId);

    /**
     * 获取收藏列表信息
     * @param openId
     * @return
     */
    @PostMapping("/getAllCollect")
    List<Product> getAllCollects(@RequestParam(value = "openId") String openId);

    /**
     * @author Seven Lee
     * @description
     *      执行登录操作
     * @param
    **/
    @PostMapping("/login")
    Boolean doLogin(@RequestParam(value = "openId")String openId);

    /**
     *浏览商品执行添加收藏操作
     * @param shopId
     * @param openId
     * @return
     */
    @PostMapping("/pCollect")
    Boolean productCollects(@RequestParam(value = "shopId") Long shopId,@RequestParam(value = "openId") String openId);


}
