package com.lanan.gulimallorder.dao;

import com.lanan.gulimallorder.entity.PaymentInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 * 
 * @author maojinzhi
 * @email 2509763868@qq.com
 * @date 2022-07-01 17:02:47
 */
@Mapper
public interface PaymentInfoDao extends BaseMapper<PaymentInfoEntity> {
	
}
