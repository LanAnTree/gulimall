package com.lanan.gulimallware.feign;

import com.lanan.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LanAn
 * @date 2022/8/17-23:36
 */
@FeignClient(value = "gulimall-product")
public interface ProductFeignService {
    /**
     * 查询消息
     * @date 2022/8/18 17:25
     * @param skuId
     * @return {@link R}
     */
    @RequestMapping("/product/skuinfo/info/{skuId}")
    R info(@PathVariable("skuId") Long skuId);
}
