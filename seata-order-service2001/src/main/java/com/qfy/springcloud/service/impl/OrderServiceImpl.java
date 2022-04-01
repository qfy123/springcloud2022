package com.qfy.springcloud.service.impl;

import com.qfy.springcloud.dao.OrderDao;
import com.qfy.springcloud.domain.Order;
import com.qfy.springcloud.service.AccountService;
import com.qfy.springcloud.service.OrderService;
import com.qfy.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;
    @Override
    @GlobalTransactional(name = "abc-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        //创建订单--减库存--减钱--改订单状态--下单成功
        log.info("----------->开始新建订单");
        orderDao.create(order);

        log.info("----------->订单微服务开始调用库存，库存减一");
        storageService.decrease(order.getProductId(),order.getCount());

        log.info("----------->库存减一成功，调用账户，扣钱");
        accountService.decrease(order.getUserId(),order.getMoney());
        //修改订单状态
        log.info("----------->修改订单状态");
        orderDao.update(order.getUserId(),0);

        log.info("----------->下单成功");


    }
}
