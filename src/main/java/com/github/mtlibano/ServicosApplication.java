package com.github.mtlibano;

import com.github.mtlibano.domain.Client;
import com.github.mtlibano.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServicosApplication {

	@Autowired
	ClientRepository clientRepository;

	@Bean
	public CommandLineRunner run() {
		return args -> {
			Client client = Client.builder().cpf("08124991901").name("Max").build();
			clientRepository.save(client);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ServicosApplication.class, args);
	}

}