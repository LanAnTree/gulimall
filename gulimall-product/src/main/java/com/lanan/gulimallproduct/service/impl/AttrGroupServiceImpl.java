package com.lanan.gulimallproduct.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.lanan.gulimallproduct.entity.AttrEntity;
import com.lanan.gulimallproduct.entity.vo.AttrGroupWithAttrsVo;
import com.lanan.gulimallproduct.service.AttrService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lanan.common.utils.PageUtils;
import com.lanan.common.utils.Query;

import com.lanan.gulimallproduct.dao.AttrGroupDao;
import com.lanan.gulimallproduct.entity.AttrGroupEntity;
import com.lanan.gulimallproduct.service.AttrGroupService;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    private AttrService attrService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageByCatelogId(Map<String, Object> params, Long catelogId) {
        //如果传过来的id是0，则查询所有属性
        if (catelogId == 0){
            //this.page两个参数，第一个参数是查询页码信息，其中Query.getPage方法传入一个map，会自动封装成IPage
            //第二个参数是查询条件，空的wapper就是查询全部
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
                    new QueryWrapper<AttrGroupEntity>());
            return new PageUtils(page);
        }else{
            String key = (String) params.get("key");
            QueryWrapper<AttrGroupEntity> wapper = new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId);
            if (!StringUtils.isEmpty(key)){
                wapper.and((obj)->{
                    obj.like("attr_group_name", key).or().eq("attr_group_id", key);
                });
            }
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
                    wapper);
            return new PageUtils(page);
        }
    }

    /**
     * 根据分类id查出所有的分组以及这些分组里面的属性
     * @date 2022/7/5 22:52
     * @param catelogId
     * @return {@link List<AttrGroupWithAttrsVo>}
     */
    @Override
    public List<AttrGroupWithAttrsVo> getAttrGroupWithAttrsByCatelogId(Long catelogId) {
        List<AttrGroupEntity> attrGroupEntities = this.baseMapper.selectList(new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId));
        List<AttrGroupWithAttrsVo> collect = attrGroupEntities.stream().map(item -> {
            AttrGroupWithAttrsVo attrsVo = new AttrGroupWithAttrsVo();
            BeanUtils.copyProperties(item, attrsVo);
            List<AttrEntity> relationAttr = attrService.getRelationAttr(item.getAttrGroupId());
            attrsVo.setAttrs(relationAttr);
            return attrsVo;
        }).collect(Collectors.toList());
        return collect;
    }

}
