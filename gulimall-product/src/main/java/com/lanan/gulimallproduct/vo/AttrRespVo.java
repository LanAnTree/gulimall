package com.lanan.gulimallproduct.vo;

import com.lanan.gulimallproduct.entity.AttrEntity;
import lombok.Data;

/**
 * @author dinner
 * @description
 * @create 2021/8/8
 */
@Data
public class AttrRespVo extends AttrVo {
    private String catelogName;
    private String groupName;
    private Long[] catelogPath;
}
