package com.lanan.gulimallware.vo;

import lombok.Data;

import java.util.List;

/**
 * @author LanAn
 * @date 2022/8/17-23:34
 */
@Data
public class PurchaseDoneVo {
    private Long id;
    private List<PurchaseItemDoneVo> items;
}
