package com.qfy.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----------PaymentFallbackService  fallback        ok";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "-----------PaymentFallbackService  fallback        超时";
    }
}
