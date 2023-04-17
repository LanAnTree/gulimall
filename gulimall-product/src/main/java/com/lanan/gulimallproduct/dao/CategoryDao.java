package com.lanan.gulimallproduct.dao;

import com.lanan.gulimallproduct.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author maojinzhi
 * @email 2509763868@qq.com
 * @date 2022-07-01 15:08:20
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
