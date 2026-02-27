package io.github.cellrepair.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI configuracaoOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("API CellRapair")
                        .version("v1.0.0")
                        .description("Documentação interativa do sistema.")
                        .contact(new Contact()
                                .name("Suporte Técnico CellRapair.")
                                .email("suporte@solowita.com")
                                .url("https://github.com/attonic/cellrapair")
                        )

                );
    }

}
