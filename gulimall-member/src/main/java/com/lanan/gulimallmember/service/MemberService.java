package com.lanan.gulimallmember.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lanan.common.utils.PageUtils;
import com.lanan.gulimallmember.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author maojinzhi
 * @email 2509763868@qq.com
 * @date 2022-07-01 17:26:38
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

