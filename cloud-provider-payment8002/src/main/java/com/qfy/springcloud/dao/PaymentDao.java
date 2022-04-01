package com.qfy.springcloud.dao;

import com.qfy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public int add(Payment payment);
    public Payment getPaymentByID(@Param("id") Long id);

}
