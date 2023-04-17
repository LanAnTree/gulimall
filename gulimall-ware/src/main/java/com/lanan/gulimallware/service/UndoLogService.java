package com.lanan.gulimallware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lanan.common.utils.PageUtils;
import com.lanan.gulimallware.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author maojinzhi
 * @email 2509763868@qq.com
 * @date 2022-07-01 17:28:41
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

