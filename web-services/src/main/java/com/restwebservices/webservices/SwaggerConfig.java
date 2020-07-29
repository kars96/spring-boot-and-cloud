package com.restwebservices.webservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Configuration
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// /v2/api-docs
//	http://localhost:8080/swagger-ui/index.html
	

	  public static final Contact DEFAULT_CONTACT
	      = new Contact(
	      "Karthik",
	      "www.k.com",
	      "karthik@mail.com");
	  public static final ApiInfo DEFAULT
	      = new ApiInfo(
	      "My REST API",
	      "Beginer's  REST practice",
	      "1.0",
	      "myrestapi.com/termsofserv",
	      DEFAULT_CONTACT,
	      "Apache 2.0",
	      "http://www.apache.org/licenses/LICENSE-2.0",
	      new ArrayList());
	
	@Bean
	Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT)
				.produces(new HashSet<String>(Arrays.asList("application/xml", "application/json")))
				.consumes(new HashSet<String>(Arrays.asList("application/xml", "application/json")));
	}
}
