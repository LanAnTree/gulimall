package com.lanan.gulimallorder.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lanan.common.utils.PageUtils;
import com.lanan.gulimallorder.entity.RefundInfoEntity;

import java.util.Map;

/**
 * 退款信息
 *
 * @author maojinzhi
 * @email 2509763868@qq.com
 * @date 2022-07-01 17:02:46
 */
public interface RefundInfoService extends IService<RefundInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

