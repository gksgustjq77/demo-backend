package com.example.demo;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


import lombok.extern.slf4j.Slf4j;
@SpringBootApplication
public class DemoApplication {
    	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
