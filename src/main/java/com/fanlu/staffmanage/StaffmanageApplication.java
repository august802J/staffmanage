package com.fanlu.staffmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.fanlu.staffmanage.mapper")
@SpringBootApplication
public class StaffmanageApplication {

	public static void main(String[] args) {
		System.setProperty("jasypt.encryptor.password", "DD5D4DB3B8EC95B3");
		SpringApplication.run(StaffmanageApplication.class, args);
	}

}
