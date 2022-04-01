package com.qfy.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component//让容器扫描到
public class MyLB implements LoadBalancer{

    /**
     * 轮询是用访问次数与服务实例个数进行取余，获得下标值，下标值对应的服务实例去服务
     * 如何获得访问次数？
     * 设置一个原子整形，初始为0，当前值为原子整形的值，访问次数为当前值+1
     * 当第一个访问到来时，当前值为0，访问次数为1，使用比较并交换方法，当前值（期望值）和内存中原子整形的值一样，返回true并更新原子整形的值为访问次数的值（也就是1），取反为false，跳出循环
     * 此时，返回访问次数的值为1，原子整形的值也为1
     * 第二次访问，当前值为1，访问次数为2，同理，再次更新原子整形的值并跳出循环，返回访问次数的值2
     */
    private AtomicInteger atomicInteger=new AtomicInteger(0);
    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current=this.atomicInteger.get();
            next=current>=Integer.MAX_VALUE ? 0:current+1;

        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("第几次访问："+next);
        return next;
    }
    //负载均衡轮询：rest接口第n次请求 % 服务器集群总数量 = 实际调用服务器位置下标，每次服务重启后rest接口计数从1开始
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        //访问次数与服务实例个数取余（轮询的原理）
        int index=getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
