package com.employee.employeeDetails.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 758344 @Bean - indicates that a method produces a bean to be managed
 *         by Spring.
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.employee.employeeDetails")).paths(PathSelectors.any())
				.build();
	}
	/*
	 * private ApiInfo apiInfo() { return new
	 * ApiInfoBuilder().title("Tele2 REST Services API")
	 * .description("Swagger documentation for the REST webservices API").build(); }
	 * 
	 * public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * registry.addResourceHandler("swagger-ui.html").addResourceLocations(
	 * "classpath:/META-INF/resources/");
	 * 
	 * registry.addResourceHandler("/webjars/**").addResourceLocations(
	 * "classpath:/META-INF/resources/webjars/"); }
	 */

}
