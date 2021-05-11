package com.yadas.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
public class RestApplication implements ApplicationRunner {

	@Value("${application.name}")
	private String applicationName;

	@Value("${application.version}")
	private String applicationVersion;

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		System.out.println("=================================================================================================================================");
		System.out.println("\t\t\t\t\t\t" + this.applicationName + "\tversion: " + this.applicationVersion);
		System.out.println("=================================================================================================================================");
	}
}
