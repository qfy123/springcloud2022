package com.qfy.springcloud.service.impl;

import com.qfy.springcloud.dao.PaymentDao;
import com.qfy.springcloud.entities.Payment;
import com.qfy.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentDao paymentDao;
    public int add(Payment payment){
        return paymentDao.add(payment);
    };
    public Payment getPaymentByID(@Param("id") Long id){
        return paymentDao.getPaymentByID(id);
    };
}
