package com.example.FluGoal.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI custoOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("API de FluGoal")
                        .version("1.0")
                        .description("Documentacion Api gestion de consultas para la App FluGoal")
                        .contact(new Contact()
                                .name("Cristian Cano & Daniel Moreno")
                                .email("canox09@gmail.com , morenodanielbenito123@gmail.com")
                        )
                );
    }
}
