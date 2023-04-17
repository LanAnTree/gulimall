package com.lanan.gulimallorder.dao;

import com.lanan.gulimallorder.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author maojinzhi
 * @email 2509763868@qq.com
 * @date 2022-07-01 17:02:46
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
