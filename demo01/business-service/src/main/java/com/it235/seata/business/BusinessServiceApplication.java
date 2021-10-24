package com.it235.seata.business;

import com.it235.seata.business.client.OrderClient;
import com.it235.seata.business.client.StorageClient;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients
@EnableDiscoveryClient
public class BusinessServiceApplication {

    @Autowired
    private OrderClient orderClient;
    @Autowired
    private StorageClient storageClient;

    @GetMapping("buy")
    @GlobalTransactional
    public String buy(long userId , long productId){
        orderClient.create(userId , productId);
        storageClient.changeStorage(userId , 1);
        return "ok";
    }

    public static void main(String[] args) {
        SpringApplication.run(BusinessServiceApplication.class, args);
    }

}
