package com.lanan.gulimallcoupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lanan.common.to.SpuBoundTo;
import com.lanan.common.utils.PageUtils;
import com.lanan.gulimallcoupon.entity.SpuBoundsEntity;

import java.util.Map;

/**
 * 商品spu积分设置
 *
 * @author maojinzhi
 * @email 2509763868@qq.com
 * @date 2022-07-01 22:55:23
 */
public interface SpuBoundsService extends IService<SpuBoundsEntity> {

    PageUtils queryPage(Map<String, Object> params);

}

