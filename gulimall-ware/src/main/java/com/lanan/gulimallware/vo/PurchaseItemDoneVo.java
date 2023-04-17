package com.lanan.gulimallware.vo;

import lombok.Data;

/**
 * @author LanAn
 * @date 2022/8/17-23:34
 */
@Data
public class PurchaseItemDoneVo {
    private Long itemId;
    private Integer status;
    private String reason;
}
