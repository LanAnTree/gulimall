package com.lanan.gulimallcoupon.feign;

import com.lanan.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author LanAn
 * @date 2022/7/3-8:00
 */
@FeignClient("gulimall-member")
public interface memberFeignService {

    /**
     * TODO
     * @date 2022/7/3 8:05
     * @param params
     * @return {@link R}
     */
    @RequestMapping("/gulimallmember/member/list")
    R list(@RequestParam Map<String, Object> params);
}
