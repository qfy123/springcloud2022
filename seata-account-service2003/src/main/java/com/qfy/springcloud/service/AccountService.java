package com.qfy.springcloud.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public interface AccountService {
    public void decrease(@RequestParam("userId")Long userId, @RequestParam("money")BigDecimal money);
}
