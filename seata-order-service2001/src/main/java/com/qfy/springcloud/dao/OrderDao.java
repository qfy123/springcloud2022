package com.qfy.springcloud.dao;

import com.qfy.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
    //新建订单
    public void create(Order order);

    //修改订单状态，从0到1
    public void update(@Param("userId")Long userId,@Param("status")Integer status);
}
