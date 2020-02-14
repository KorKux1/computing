package co.edu.icesi.parcial.nombre.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.icesi.parcial.nombre.logic.BillLogic;
import co.edu.icesi.parcial.nombre.repository.BillRepository;

@Configuration
public class AppConfig {

	@Bean
	public BillRepository BillRepository(BillRepository repos) {
		return repos;}
	
	@Bean
	public BillLogic BillLogic(BillLogic logic) {
		return logic;
	}

}
