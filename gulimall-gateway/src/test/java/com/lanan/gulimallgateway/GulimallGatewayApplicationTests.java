package com.lanan.gulimallgateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallGatewayApplicationTests {

    @Test
    void contextLoads() {
        Long start = Long.parseLong("000100001000111010001101011100011");
        System.out.println(start);
    }

}
