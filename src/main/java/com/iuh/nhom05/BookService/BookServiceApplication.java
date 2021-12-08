package com.iuh.nhom05.BookService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class BookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@Bean
	public Docket swaggerConfiguration() {
		// Return a prepared Docket instance
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/books/**"))
				.apis(RequestHandlerSelectors.basePackage("com.iuh.nhom05"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Book Service API",
				"APIs for Book Service",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Nhóm 05", "http://fit.iuh.edu.vn/home.html", "a@b.com"),
				"API License",
				"http://fit.iuh.edu.vn/home.html",
				Collections.emptyList());
	}
}
