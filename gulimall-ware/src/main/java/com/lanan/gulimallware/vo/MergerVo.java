package com.lanan.gulimallware.vo;

import lombok.Data;

import java.util.List;

/**
 * @author LanAn
 * @date 2022/8/17-23:25
 */
@Data
public class MergerVo {
    /**
     * 整单id
     **/
    private Long purchaseId;
    /**
     * 合并项集合
     **/
    private List<Long> items;
}

