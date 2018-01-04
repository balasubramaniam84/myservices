package com.techprimers.stock.dbservice.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.techprimers.stock.dbservice.resource"))
				.paths(PathSelectors.regex("/rest.*")).build().apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		// TODO Auto-generated method stub
		ApiInfo apiInfo = new ApiInfo("Database Services",
				"This is a simple service used to store and retrieve User details like name and age", "1.0",
				"terms of service", new Contact("Balasubramaniam", "http://www.cdac.in", "mbalasubramaniam@cdac.in"),
				"@ Cdac Noida", "http://www.cdac.in");

		return apiInfo;
	}
}
