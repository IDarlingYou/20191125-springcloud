package com.aaa.lee.app.fallback;

import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.MemberReceiveAddress;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.domain.ProductCat;
import com.aaa.lee.app.service.IRepastService;
import com.aaa.lee.app.vo.ShopInfoVo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Date Create in 2019/11/20 11:41
 * @Description
 **/
@Component
public class RepastFallBackFactory implements FallbackFactory<IRepastService> {

    @Override
    public IRepastService create(Throwable throwable) {
        IRepastService repastService = new IRepastService() {
            @Override
            public int addMemberMessages(Member member) {
                System.out.println("测试添加用户信息");
                return 0;
            }

            @Override
            public Boolean orderCollects(Long orderId, String openId) {
                System.out.println("测试订单商品收藏熔断数据");
                return null;
            }

            @Override
            public List<Product> getAllCollects(String openId) {
                System.out.println("测试获取收藏信息列表");
                return null;
            }

            @Override
            public Boolean doLogin(String openId) {
                System.out.println("测试登录熔断数据");
                return null;
            }

            @Override
            public Boolean productCollects(Long shopId, String openId) {
                System.out.println("测试商品收藏熔断数据");
                return null;
            }

        };
        return repastService;
    }
}
