package ru.gb.eurekaclientview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientViewApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientViewApplication.class, args);
    }

}
