package com.lanan.gulimallware.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.lanan.gulimallware.vo.MergerVo;
import com.lanan.gulimallware.vo.PurchaseDoneVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lanan.gulimallware.entity.PurchaseEntity;
import com.lanan.gulimallware.service.PurchaseService;
import com.lanan.common.utils.PageUtils;
import com.lanan.common.utils.R;

/**
 * 采购信息
 *
 * @author maojinzhi
 * @email 2509763868@qq.com
 * @date 2022-07-01 17:28:41
 */
@RestController
@RequestMapping("gulimallware/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("gulimallware:purchase:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseService.queryPage(params);

        return R.ok().put("page", page);
    }

    @PostMapping("/merge")
    //@RequiresPermissions("ware:purchase:list")
    public R merge(@RequestBody MergerVo mergerVo){
        purchaseService.mergePurchase(mergerVo);
        return R.ok();
    }

    /**
     * 领取采购单/ware/purchase/received
     */
    @PostMapping("/received")
    //@RequiresPermissions("ware:purchase:list")
    public R received(@RequestBody List<Long> ids){
        purchaseService.received(ids);
        return R.ok();
    }

    /**
     * 完成采购
     */
    @PostMapping("/done")
    //@RequiresPermissions("ware:purchase:list")
    public R received(@RequestBody PurchaseDoneVo vo){
        purchaseService.done(vo);
        return R.ok();
    }

    @RequestMapping("/unreceive/list")
    //@RequiresPermissions("ware:purchase:list")
    public R unreceiveList(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseService.queryPageUnreceive(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("gulimallware:purchase:info")
    public R info(@PathVariable("id") Long id){
		PurchaseEntity purchase = purchaseService.getById(id);

        return R.ok().put("purchase", purchase);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("gulimallware:purchase:save")
    public R save(@RequestBody PurchaseEntity purchase){
		purchaseService.save(purchase);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("gulimallware:purchase:update")
    public R update(@RequestBody PurchaseEntity purchase){
		purchaseService.updateById(purchase);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("gulimallware:purchase:delete")
    public R delete(@RequestBody Long[] ids){
		purchaseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
