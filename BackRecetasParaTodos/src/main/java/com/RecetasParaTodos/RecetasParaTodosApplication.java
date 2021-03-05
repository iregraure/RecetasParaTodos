package com.RecetasParaTodos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.RecetasParaTodos.security.common.SecurityConstants;

@SpringBootApplication
public class RecetasParaTodosApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecetasParaTodosApplication.class, args);
	}
	
	public WebMvcConfigurer corsConfigurer()
	{
		return new WebMvcConfigurer() 
		{
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE").exposedHeaders(SecurityConstants.HEADER_STRING);
			}	
		};
	}

}
