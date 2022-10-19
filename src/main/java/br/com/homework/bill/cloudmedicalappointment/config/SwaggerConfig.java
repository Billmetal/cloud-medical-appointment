package br.com.homework.bill.cloudmedicalappointment.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.homework.bill.cloudmedicalappointment"))
				.build()
				.apiInfo(metaData())
				.securityContexts(Arrays.asList(getSecurityContext()))
				.securitySchemes(Arrays.asList(basicAuthScheme()));
	}

	private SecurityScheme basicAuthScheme() {
		return new BasicAuth("basicAuth");
	}

	private SecurityContext getSecurityContext() {
		return SecurityContext.builder()
				.securityReferences(Arrays.asList(basicAuthReferences()))
				.build();
	}

	private SecurityReference basicAuthReferences() {
		return new SecurityReference("basicAuth", new AuthorizationScope[0]);
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder()
				.title("Appointment Rest Api")
				.description("Spring boot REST API for Medical Appointment")
				.version("1.0.0")
				.license("Apache License")
				.licenseUrl("https://www.apache.org/licenses/")
				.build();
	}
}
