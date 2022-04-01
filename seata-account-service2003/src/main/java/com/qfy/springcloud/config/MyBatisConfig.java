package com.qfy.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.qfy.springcloud.dao")
public class MyBatisConfig {
}
