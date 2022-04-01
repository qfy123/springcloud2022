package com.qfy.springcloud.service;

import com.qfy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int add(Payment payment);
    public Payment getPaymentByID(@Param("id") Long id);
}
