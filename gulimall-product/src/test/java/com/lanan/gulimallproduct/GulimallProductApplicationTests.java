package com.lanan.gulimallproduct;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lanan.gulimallproduct.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
//        BinaryLogClient client =
//                new BinaryLogClient("127.0.0.1", 3306,  "root", "password");
//        client.setServerId(2);
//
//        client.registerEventListener(event -> {
//            EventData data = event.getData();
//            if (data instanceof TableMapEventData) {
//                System.out.println("Table:");
//                TableMapEventData tableMapEventData = (TableMapEventData) data;
//                System.out.println(tableMapEventData.getTableId()+": ["+tableMapEventData.getDatabase() + "-" + tableMapEventData.getTable()+"]");
//            }
//            if (data instanceof UpdateRowsEventData) {
//                System.out.println("Update:");
//                System.out.println(data.toString());
//            } else if (data instanceof WriteRowsEventData) {
//                System.out.println("Insert:");
//                System.out.println(data.toString());
//            } else if (data instanceof DeleteRowsEventData) {
//                System.out.println("Delete:");
//                System.out.println(data.toString());
//            }
//        });
//
//        try {
//            client.connect();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
