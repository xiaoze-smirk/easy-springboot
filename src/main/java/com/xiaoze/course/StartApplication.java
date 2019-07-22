package com.xiaoze.course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * StartApplication
 *
 * @author xiaoze
 * @date 2018/6/3
 * 这里用的是mapper的扫描，不是mybatis自身扫描
 *
 */
@MapperScan("com.xiaoze.course.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
