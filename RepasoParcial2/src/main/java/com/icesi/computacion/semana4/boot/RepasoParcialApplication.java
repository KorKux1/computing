package com.icesi.computacion.semana4.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.icesi.computacion.semana4.service.PersonService;

@SpringBootApplication
@ComponentScan("com.icesi.computacion.semana4")
public class RepasoParcialApplication {
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =  SpringApplication.run(RepasoParcialApplication.class, args);
		PersonService personService = ctx.getBean(PersonService.class);
		personService.addPerson("Juan", "Antonio");
		personService.addPerson("Steven", "Aristizabal");
		personService.removePerson("Aristizabal");
		personService.removePerson("Antonio");
	}
}
