package com.asdn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.asdn.backstage.mapper"})
public class StarterBagestage {
	public static void main(String[] args){
		SpringApplication.run(StarterBagestage.class, args);
	}
}
