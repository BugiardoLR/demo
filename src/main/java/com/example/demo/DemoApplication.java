package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    //TODO Add Non-blocking kafka consumer to save the messages to the DB

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

