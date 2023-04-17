package com.lanan.gulimallware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LanAn
 * @date 2022/7/1-18:19
 */
@MapperScan("com.lanan.gulimallware.dao")
@EnableFeignClients(basePackages = "com.lanan.gulimallware.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallWareApplication {
    public static void main(String[] args) {
        SpringApplication.run(GulimallWareApplication.class, args);
    }
}
