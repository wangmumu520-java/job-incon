package com.wly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import sun.applet.Main;

@SpringBootApplication
@EnableDiscoveryClient
public class companyApplication {
    public static void main(String[] args) {
        SpringApplication.run(companyApplication.class,args);
    }
}
