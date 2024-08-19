package com.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

/*	@Bean
	CommandLineRunner commandLineRunner(ObjectMapper objectMapper) throws JsonProcessingException {
		String personString ="{\"id\":1,\"Full Name\":\"ghady\",\"age\":22}";
		Person person = objectMapper.readValue(personString, Person.class);
		System.out.println(person);
		System.out.println(objectMapper.writeValueAsString(person));
		return args -> {

		};
	}*/





}
