package com.ailaysa.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocsConfig {

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2) // Specify the Swagger version
				.select() // Start defining the selection criteria for the APIs
				.apis(RequestHandlerSelectors.basePackage("com.ailaysa.restcontroller")) 
				.paths(PathSelectors.regex("/api/.*")) 
				.build() 
				.useDefaultResponseMessages(true) // Use default response messages
				.apiInfo(getApiInfo()); // Provide API information
	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("safvan", "www.ailaysa.com", "safvanpmcz@gmail.com");

		return new ApiInfo("ailaysa Rest API's", //  of the API documentation
				"Gives information about few Text processing API's", // description of the API documentation
				"3.4.RELEASE", // Specify the version of the API documentation
				"https://helpcenter.ailaysa.com/", // terms of services URL
				contact, // contact information
				"GNU PUBLIC", //  license name
				"https://www.apache.org/licenses/LICENSE-2.0.html", // license URL
				Collections.emptyList()); // vendor ext
	}
}
