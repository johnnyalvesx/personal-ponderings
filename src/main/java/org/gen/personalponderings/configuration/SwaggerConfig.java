package org.gen.personalponderings.configuration;


import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.apache.catalina.connector.Response;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

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
//                .components(createGlobalResponses());

    }
//    private Components createGlobalResponses() {
//        Components components = new Components();
//        components.addResponses("200", new io.swagger.v3.oas.models.responses.ApiResponse().description("Sucesso!"));
//        components.addResponses("201", new io.swagger.v3.oas.models.responses.ApiResponse().description("Criado!"));
//        components.addResponses("400", new io.swagger.v3.oas.models.responses.ApiResponse().description("Erro na requisição!"));
//        components.addResponses("401", new io.swagger.v3.oas.models.responses.ApiResponse().description("Não Autorizado!"));
//        components.addResponses("403", new io.swagger.v3.oas.models.responses.ApiResponse().description("Proibido!"));
//        components.addResponses("404", new io.swagger.v3.oas.models.responses.ApiResponse().description("Não Encontrado!"));
//        components.addResponses("500", new io.swagger.v3.oas.models.responses.ApiResponse().description("Erro!"));
//        return components;
//    }



}
