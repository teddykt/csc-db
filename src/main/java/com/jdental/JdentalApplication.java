package com.jdental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

@SpringBootApplication
public class JdentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdentalApplication.class, args);
	}

}
