package com.lanan.gulimallproduct.service.impl;

import com.lanan.gulimallproduct.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lanan.common.utils.PageUtils;
import com.lanan.common.utils.Query;

import com.lanan.gulimallproduct.dao.CategoryDao;
import com.lanan.gulimallproduct.entity.CategoryEntity;
import com.lanan.gulimallproduct.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 查询所有结果组装成树
     *
     * @return {@link List < CategoryEntity>}
     * @date 2022/7/3 15:08
     */
    @Override
    public List<CategoryEntity> listWithTree() {
        // 查询所有数据
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        // 查找一级分类
        return categoryEntities.stream()
                // 一级数据
                .filter(entity -> entity.getParentCid() == 0)
                // 赋子节点
                .peek(menu -> menu.setChildren(getChildren(menu, categoryEntities)))
                // 按照sort字段排序
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                //转换为list
                .collect(Collectors.toList());
    }

    /**
     * delete
     * @date 2022/7/4 15:47
     * @param catIds
     */
    @Override
    public void removeMenuByIds(List<Long> catIds) {
        //TODO 1、检查当前删除的菜单，是否被别的地方引用
        baseMapper.deleteBatchIds(catIds);
    }

    /**
     * 功能描述
     * @date 2022/7/3 16:09
     * @param root
     * @param categoryEntities
     * @return {@link List< CategoryEntity>}
     */
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> categoryEntities) {
        return categoryEntities.stream()
                // 每级数据
                .filter(entity -> entity.getParentCid().equals(root.getCatId()))
                // 赋子节点
                .peek(menu -> menu.setChildren(getChildren(menu, categoryEntities)))
                // 按照sort字段排序
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                //转换为list
                .collect(Collectors.toList());
    }

    /**
     * 完整路径
     *
     * @param catelogId
     * @return {@link Long[]}
     * @date 2022/7/5 16:05
     */
    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> paths = new ArrayList<>();
        List<Long> parentPath = findParentPath(catelogId, paths);
        return parentPath.toArray(new Long[parentPath.size()]);
    }

    /**
     * 递归查找父节点id
     * @date 2022/7/5 16:06
     * @param catelogId
     * @param paths
     * @return {@link List<Long>}
     */
    public List<Long> findParentPath(Long catelogId,List<Long> paths){
        //1、收集当前节点id
        CategoryEntity byId = this.getById(catelogId);
        if (byId.getParentCid() != 0){
            findParentPath(byId.getParentCid(), paths);
        }
        paths.add(catelogId);
        return paths;
    }

    /**
     * 更新
     *
     * @param category
     * @date 2022/7/5 17:23
     */
    @Transactional
    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        categoryBrandRelationService.updateCategory(category.getCatId(), category.getName());
    }

}
