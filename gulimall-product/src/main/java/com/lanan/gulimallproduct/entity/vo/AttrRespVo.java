package com.lanan.gulimallproduct.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LanAn
 * @date 2022/7/5-17:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AttrRespVo extends AttrVo {
    private String catelogName;
    private String groupName;
    private Long[] catelogPath;
}

