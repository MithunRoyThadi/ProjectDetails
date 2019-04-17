package com.mqmft.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.mqmft.rest.api.utility.LoadGlobalProperties;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan("com.mqmft.*")
@SpringBootApplication
public class MQMFT_Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		System.setProperty("spring.global.filepath", "C:\\MFT\\MQMFTProperties.properties");
		LoadGlobalProperties.refreshGlobalProperties();
		SpringApplication.run(MQMFT_Application.class, args);
	}
	
	static {
		System.setProperty("spring.global.filepath", "C:\\MFT\\MQMFTProperties.properties");
		LoadGlobalProperties.refreshGlobalProperties();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MQMFT_Application.class);
	}
}

