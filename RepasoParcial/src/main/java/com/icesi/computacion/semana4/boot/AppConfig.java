/**
 * 
 */
package com.icesi.computacion.semana4.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.icesi.computacion.semana4.repository.PersonRepositoryImp;
import com.icesi.computacion.semana4.service.PersonServiceImp;

/**
 * @author computacion19.2
 *
 */
@Configuration
public class AppConfig {
	
	@Bean
	@Lazy
	public PersonRepositoryImp personRepositoryImp() {
		return new PersonRepositoryImp();
	}
	
	@Bean
	public PersonServiceImp personServiceImp() {
		return new PersonServiceImp();
	}

}
