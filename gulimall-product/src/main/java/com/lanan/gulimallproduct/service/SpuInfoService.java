package com.lanan.gulimallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lanan.common.utils.PageUtils;
import com.lanan.gulimallproduct.entity.SpuInfoDescEntity;
import com.lanan.gulimallproduct.entity.SpuInfoEntity;
import com.lanan.gulimallproduct.vo.SpuSaveVo;

import java.util.Map;

/**
 * spu信息
 *
 * @author maojinzhi
 * @email 2509763868@qq.com
 * @date 2022-07-01 22:48:30
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSpuInfo(SpuSaveVo vo);

    void saveBaseSpuInfo(SpuInfoEntity infoEntity);

    PageUtils queryPageByCondition(Map<String, Object> params);

    void up(Long spuId);
}

