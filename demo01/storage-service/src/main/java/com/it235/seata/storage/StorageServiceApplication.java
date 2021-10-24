package com.it235.seata.storage;

import com.it235.seata.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

@RestController
@SpringBootApplication
@MapperScan("com.it235.seata.storage.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class StorageServiceApplication {

    @Autowired
    private StorageService storageService;

    @GetMapping("storage/change")
    public Boolean changeStorage(long productId , int used)  {

      //  int sd = 0 / 0;
        return storageService.updateUseNum(productId , used);
    }

    public static void main(String[] args) {
        SpringApplication.run(StorageServiceApplication.class, args);
    }

}
