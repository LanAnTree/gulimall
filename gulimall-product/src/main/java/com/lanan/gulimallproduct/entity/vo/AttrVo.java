package com.lanan.gulimallproduct.entity.vo;

import com.lanan.gulimallproduct.entity.AttrEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LanAn
 * @date 2022/7/5-17:42
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AttrVo extends AttrEntity {
    private Long attrGroupId;
}
