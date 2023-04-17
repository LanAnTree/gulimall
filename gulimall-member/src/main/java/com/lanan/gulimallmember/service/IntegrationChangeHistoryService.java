package com.lanan.gulimallmember.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lanan.common.utils.PageUtils;
import com.lanan.gulimallmember.entity.IntegrationChangeHistoryEntity;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author maojinzhi
 * @email 2509763868@qq.com
 * @date 2022-07-01 17:26:38
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

