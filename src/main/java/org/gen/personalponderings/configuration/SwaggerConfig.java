package org.gen.personalponderings.configuration;

//import io.swagger.v3.oas.annotations.info.Contact;

import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI documentation() {
        return new OpenAPI()
                .info(new Info()
                        .title("Personal Pondering Swagger")
                        .version("1.0.0")
                        .description("Esta é uma API para gerenciar ponderações pessoais.")
                        .license(new License()
                                .name("Pertence ao johnnyalvesx")
                                .url("https://github.com/johnnyalvesx"))
                        .contact(new Contact()
                                .name("Johnny Alves")
                                .email("johnnyalves@example.com")
                                .url("https://github.com/johnnyalvesx")));
    }
}
