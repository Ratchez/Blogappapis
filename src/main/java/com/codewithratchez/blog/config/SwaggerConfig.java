package com.codewithratchez.blog.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {
    @Bean
    public OpenAPI baseOpenApi(){
        return new OpenAPI().info(new Info().title("Blog app : Backend").description("Project that has functionalities of blog").version("1.0")
                .termsOfService("Terms of Service").contact(new Contact().name("Ratchez").email("royrasugu38@gmail.com").url("https://royrasugu.github.io/Portfolio/"))
                .license(new License().name("license of APIs")));
    }
}
