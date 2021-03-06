package br.com.devnaldo.api_heros;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class ApiHerosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiHerosApplication.class, args);
		System.out.println("Super poderes com webflux");
	}

}
