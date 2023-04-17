package com.lanan.gulimallproduct.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @desc SpringBeanConfiguration
 *      在这里配置我们自定义的LoadBalancer策略
 *      注：这里的类为注入Bean的类，而非负载均衡的实现类
 * @author lanan
 * @date 2022-07-06 11:04:44
 **/
//@Configuration
//@LoadBalancerClient(name = "gulimall-product", configuration = {NacosSameClusterConfiguration.class})
public class SpringBeanConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
