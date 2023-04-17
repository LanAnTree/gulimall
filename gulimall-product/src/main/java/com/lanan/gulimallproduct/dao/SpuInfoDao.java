package com.lanan.gulimallproduct.dao;

import com.lanan.gulimallproduct.entity.SpuInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * spu信息
 *
 * @author maojinzhi
 * @email 2509763868@qq.com
 * @date 2022-07-01 22:48:30
 */
@Mapper
public interface SpuInfoDao extends BaseMapper<SpuInfoEntity> {

    void updateSpuStatus(Long spuId, int code);
}
