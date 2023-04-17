package com.lanan.gulimallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lanan.common.utils.PageUtils;
import com.lanan.gulimallproduct.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author maojinzhi
 * @email 2509763868@qq.com
 * @date 2022-07-01 15:08:20
 */
public interface CategoryService extends IService<CategoryEntity> {

    /**
     * 分页查询
     * @date 2022/7/3 15:17
     * @param params
     * @return {@link PageUtils}
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询所有结果组装成树
     * @date 2022/7/3 15:08
     * @return {@link List<CategoryEntity>}
     */
    List<CategoryEntity> listWithTree();

    /**
     * delete 判断是否删除
     * @date 2022/7/4 15:46
     * @param catIds
     */
    void removeMenuByIds(List<Long> catIds);

    /**
     * 完整路径
     * @date 2022/7/5 16:05
     * @param catelogId
     * @return {@link Long[]}
     */
    Long[] findCatelogPath(Long catelogId);

    /**
     * 更新
     * @date 2022/7/5 17:23
     * @param entity
     */
    void updateCascade(CategoryEntity entity);
}

