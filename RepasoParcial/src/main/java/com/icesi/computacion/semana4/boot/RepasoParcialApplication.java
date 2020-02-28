package com.icesi.computacion.semana4.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.icesi.computacion.semana4.service.PersonServiceImp;

import lombok.extern.java.Log;

@SpringBootApplication
@Log
public class RepasoParcialApplication {
	
	@Autowired
	private PersonServiceImp personServiceImp;
	
	public static void main(String[] args) {
		SpringApplication.run(RepasoParcialApplication.class, args);
	}

	@Bean
	public CommandLineRunner dummy(PersonServiceImp personServiceImp) {
		return (args) -> {
			personServiceImp.addPerson("Juan", "Martinez");
			personServiceImp.addPerson("Jorge", "Castro");
 			personServiceImp.removePerson("Castro");
			personServiceImp.removePerson("Martinez");
		};
	} 
}
