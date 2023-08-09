package com.br;

import java.awt.Desktop;
import java.net.URI;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.br.model")
@EnableJpaRepositories("com.br.repository")
public class Application {

    @Value("${custom.swaggerUrl}") // Lê a propriedade do arquivo YAML
    private String swaggerUrl;

    @Bean
    public ModelMapper modelMapper() throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        return modelMapper;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            // Acessar a nova URL do Swagger que foi lida do YAML
            Desktop.getDesktop().browse(new URI(args[0])); // Passa a URL como argumento
        }
    }
}
