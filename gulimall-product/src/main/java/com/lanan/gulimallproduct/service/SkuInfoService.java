package com.lanan.gulimallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lanan.common.utils.PageUtils;
import com.lanan.gulimallproduct.entity.SkuInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * sku信息
 *
 * @author maojinzhi
 * @email 2509763868@qq.com
 * @date 2022-07-01 15:08:20
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSkuInfo(SkuInfoEntity skuInfoEntity);

    PageUtils queryPageByCondition(Map<String, Object> params);

    List<SkuInfoEntity> getSkuBySpuId(Long spuId);
}

