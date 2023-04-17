package com.lanan.gulimallorder.dao;

import com.lanan.gulimallorder.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author maojinzhi
 * @email 2509763868@qq.com
 * @date 2022-07-01 17:02:46
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
