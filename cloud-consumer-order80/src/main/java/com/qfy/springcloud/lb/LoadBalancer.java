package com.qfy.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 手写一个负载均衡轮询算法
 */
public interface LoadBalancer {
    //得到所有服务的实例
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
