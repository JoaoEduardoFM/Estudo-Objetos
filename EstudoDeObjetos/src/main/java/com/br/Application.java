package com.br;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EntityScan("com.br.model") // Escaneia o pacote com as entidades JPA
@EnableJpaRepositories("com.br.repository") // Configuração do pacote com os repositórios JPA
@EnableScheduling
public class Application {
	
	@Bean
	public ModelMapper modelMapper(){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setSkipNullEnabled(true);
		return modelMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
