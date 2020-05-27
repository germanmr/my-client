package com.mycompany.myclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.mycompany.myclient"})
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.mycompany.myclient"})
public class MyClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyClientApplication.class, args);
    }
}