package com.br;

import java.awt.Desktop;
import java.net.URI;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.br.model")
@EnableJpaRepositories("com.br.repository")
public class Application {

	@Bean
	public ModelMapper modelMapper() throws Exception {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setSkipNullEnabled(true);
		return modelMapper;
	}

	public static void main(String[] args) throws Exception {
		String swaggerUrl = "http://localhost:8080/swagger-ui.html#/";
	
		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
			SpringApplication.run(Application.class, args);
			Desktop.getDesktop().browse(new URI(swaggerUrl));		
		}
	}
}
