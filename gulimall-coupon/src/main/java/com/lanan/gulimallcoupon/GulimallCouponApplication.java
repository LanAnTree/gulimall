package com.lanan.gulimallcoupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LanAn
 * @date 2022/7/1-18:21
 */
@MapperScan("com.lanan.gulimallcoupon.dao")
@EnableFeignClients(basePackages = "com.lanan.gulimallcoupon.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallCouponApplication {
    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }

}
