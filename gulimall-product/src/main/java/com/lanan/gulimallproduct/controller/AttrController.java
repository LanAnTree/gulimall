package com.lanan.gulimallproduct.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.lanan.common.to.SpuBoundTo;
import com.lanan.gulimallproduct.entity.ProductAttrValueEntity;
import com.lanan.gulimallproduct.entity.vo.AttrRespVo;
import com.lanan.gulimallproduct.entity.vo.AttrVo;
import com.lanan.gulimallproduct.feign.CouponFeignService;
import com.lanan.gulimallproduct.service.ProductAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lanan.gulimallproduct.entity.AttrEntity;
import com.lanan.gulimallproduct.service.AttrService;
import com.lanan.common.utils.PageUtils;
import com.lanan.common.utils.R;



/**
 * 商品属性
 *
 * @author maojinzhi
 * @email 2509763868@qq.com
 * @date 2022-07-01 22:48:30
 */
@RestController
@RequestMapping("gulimallproduct/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    @Autowired
    private CouponFeignService feignService;

    @Autowired
    private ProductAttrValueService productAttrValueService;

    @RequestMapping("/test")
    public R test() {
        SpuBoundTo spuBoundTo = new SpuBoundTo();
        spuBoundTo.setSpuId(100L);
        spuBoundTo.setBuyBounds(BigDecimal.valueOf(1000));
        spuBoundTo.setGrowBounds(BigDecimal.valueOf(1000));
        return feignService.saveSpuBounds(spuBoundTo);
    }


    @GetMapping("/base/listforspu/{spuId}")
    public R baseListforspu(@PathVariable("spuId") Long spuId){
        List<ProductAttrValueEntity> entityList = productAttrValueService.baseAttrlistForSpu(spuId);

        return R.ok().put("data", entityList);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("gulimallproduct:attr:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }

//    @RequestMapping("/base/list/{catelogId}")
//    public R baseList(@RequestParam Map<String, Object> params, @PathVariable("catelogId") Long catelogId){
//        PageUtils page = attrService.queryBaseAttrPage(params, catelogId);
//        return R.ok().put("page", page);
//    }

    /**
     * 信息
     */
    // @RequiresPermissions("gulimallproduct:attr:info")
    @RequestMapping("/info/{attrId}")
    public R info(@PathVariable("attrId") Long attrId){
        AttrRespVo attrRespVo = attrService.getAttrInfo(attrId);

        return R.ok().put("attr", attrRespVo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("gulimallproduct:attr:save")
    public R save(@RequestBody AttrVo attr){
        attrService.saveAttr(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("gulimallproduct:attr:update")
    public R update(@RequestBody AttrVo attr){
        attrService.updateAttr(attr);

        return R.ok();
    }

    @PostMapping("/update/{spuId}")
    public R updateSpuAttr(@PathVariable("spuId") Long spuId, @RequestBody List<ProductAttrValueEntity> entities){
        productAttrValueService.updateSpuAttr(spuId, entities);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("gulimallproduct:attr:delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

    @RequestMapping("/{attrType}/list/{catelogId}")
    public R baseList(@RequestParam Map<String, Object> params, @PathVariable("catelogId") Long catelogId,
                      @PathVariable("attrType") String attrType){
        PageUtils page = attrService.queryBaseAttrPage(params, catelogId, attrType);
        return R.ok().put("page", page);
    }

}
