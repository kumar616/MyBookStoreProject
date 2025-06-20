package com.jlcindia.placeorder;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class JLCPlaceOrderConfig implements WebMvcConfigurer {
	
	
	private ApiInfo getApiDetails() {
		return new ApiInfo("JLC BookStore- API",
		"BookSearch API - part of BookStore", "1.0",
		"Free to use ",
		new Contact("Srinivas Dande", "https://www.jlcindia.com", "sri@jlcindia.com"),
		"API Under Free Licence",
		"https://www.jlcindia.com");
		}
	
		@Bean
		public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
		.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
		.build().apiInfo(getApiDetails());
		}
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//enabling swagger-ui
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		}
}
