package com.bistu.firstSpringBoot;
/**
 * @author Super-Zhang
 * @date 2021-06-29 21:27
 */
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@EnableScheduling
@MapperScan(value = "com.bistu.firstSpringBoot.dao")
public class MainApplication {
    public static void main(String[] args){
        SpringApplication.run(MainApplication.class, args);
    }
}