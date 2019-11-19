package com.learning.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaServer
@SpringBootApplication
public class FirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstApplication.class, args);
    }


    @GetMapping("/hellowold")
    public String sayHelloWorld() {
        String str  = "helloWorld";
        return str;
    }

    @GetMapping("/mathTest")
    public int mathTest() {
        int result = 0;
        for(int x = 1 ; x < 50 ; x++) {
            result += x;
        }
        return result;
    }

}
