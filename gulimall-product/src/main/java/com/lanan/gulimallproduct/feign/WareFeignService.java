package com.lanan.gulimallproduct.feign;

import com.lanan.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @desc WareFeignService
 * @author lanan
 * @date 2022-08-21 10:39:20
 **/
@FeignClient("gulimall-ware")
public interface WareFeignService {

    @PostMapping(value = "/gulimallware/waresku/hasStock")
    R getSkuHasStock(@RequestBody List<Long> skuIds);

}
