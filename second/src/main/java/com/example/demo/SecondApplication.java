package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication //내가 설정클래스파일+스프링시작tomcat시작
@ComponentScan
@ComponentScan(basePackages = "upload_16")
@ComponentScan(basePackages ="spring.mybatis_15")
@ComponentScan(basePackages ="board.spring.mybatis")
@MapperScan(basePackages = "board.spring.mybatis")
@MapperScan(basePackages = "spring.mybatis_15")
@ComponentScan(basePackages = "websocket")
@ComponentScan(basePackages = "dbsecure")
public class SecondApplication {
	public static void main(String[] args) {
		SpringApplication.run(SecondApplication.class, args);
	}

}
