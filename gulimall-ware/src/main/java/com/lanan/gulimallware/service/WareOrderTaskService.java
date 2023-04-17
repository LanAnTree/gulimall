package com.lanan.gulimallware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lanan.common.utils.PageUtils;
import com.lanan.gulimallware.entity.WareOrderTaskEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author maojinzhi
 * @email 2509763868@qq.com
 * @date 2022-07-01 17:28:40
 */
public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

