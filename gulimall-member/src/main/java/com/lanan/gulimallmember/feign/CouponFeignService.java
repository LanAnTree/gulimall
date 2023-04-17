package com.lanan.gulimallmember.feign;

import com.lanan.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LanAn
 * @date 2022/7/3-0:15
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    /**
     * 测试 RPC调用
     * @date 2022/7/3 0:18
     * @return {@link R}
     */
    @RequestMapping("/gulimallcoupon/coupon/member/coupon")
    R memberCouponTest();
}
