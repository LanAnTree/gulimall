package com.lanan.gulimallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lanan.common.utils.PageUtils;
import com.lanan.gulimallproduct.entity.AttrAttrgroupRelationEntity;
import com.lanan.gulimallproduct.entity.vo.AttrGroupRelationVo;

import java.util.List;
import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author maojinzhi
 * @email 2509763868@qq.com
 * @date 2022-07-01 22:48:30
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveBatch(List<AttrGroupRelationVo> vos);

}

