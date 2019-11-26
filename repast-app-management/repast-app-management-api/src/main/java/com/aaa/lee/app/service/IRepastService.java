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
 * @Date Create in 2019/11/20 11:40
 * @Description
 *
 **/
@FeignClient(value = "userinfo-interface-provider", fallbackFactory = RepastFallBackFactory.class)
public interface IRepastService {


    /**
     * 首次登陆，添加用户信息
     * @param member
     * @return
     */
    @PostMapping("/addMessage")
    int addMemberMessages(@RequestBody Member member);

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
