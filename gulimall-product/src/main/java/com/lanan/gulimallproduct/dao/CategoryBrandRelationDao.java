package com.lanan.gulimallproduct.dao;

import com.lanan.gulimallproduct.entity.CategoryBrandRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 品牌分类关联
 *
 * @author maojinzhi
 * @email 2509763868@qq.com
 * @date 2022-07-01 15:08:20
 */
@Mapper
public interface CategoryBrandRelationDao extends BaseMapper<CategoryBrandRelationEntity> {

    void updateCategroy(@Param("catId") Long catId, @Param("name") String name);

}
