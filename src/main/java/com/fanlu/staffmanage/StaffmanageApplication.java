package com.fanlu.staffmanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StaffmanageApplication {

	public static void main(String[] args) {
		System.setProperty("jasypt.encryptor.password", "DD5D4DB3B8EC95B3");
		SpringApplication.run(StaffmanageApplication.class, args);
	}

}
