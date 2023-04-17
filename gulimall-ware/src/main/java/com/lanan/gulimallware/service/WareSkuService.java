package com.lanan.gulimallware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lanan.common.to.SkuHasStockVo;
import com.lanan.common.utils.PageUtils;
import com.lanan.gulimallware.entity.WareSkuEntity;
import com.lanan.gulimallware.vo.WareSkuLockVo;

import java.util.List;
import java.util.Map;

/**
 * 商品库存
 *
 * @author maojinzhi
 * @email 2509763868@qq.com
 * @date 2022-07-01 17:28:41
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void addStock(Long skuId, Long wareId, String skuName, Integer skuNum);

    boolean orderLockStock(WareSkuLockVo vo);

    List<SkuHasStockVo> getSkuHasStock(List<Long> skuIds);
}

