package co.edu.icesi.parcial.nombre.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import co.edu.icesi.parcial.nombre.logic.BillLogic;
import co.edu.icesi.parcial.nombre.model.Bill;
import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
@ComponentScan("co")
public class ParcialApplication {
	
	@Autowired
	private BillLogic service;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ParcialApplication.class);
		
		ParcialApplication entrypoint1 = ctx.getBean(ParcialApplication.class);
		BillLogic entrypoint2 = ctx.getBean(BillLogic.class);
		entrypoint1.metodo();
		
		entrypoint2.addBill(new Bill("B1", "Jorge", "Morales"));
		log.info(entrypoint2.getBill("B1").getFirstName());
		
	}
	
	public void metodo() {
		service.addBill(new Bill("B2", "Ipa", "Nuñez"));
		log.info(service.getBill("B2").getFirstName());
	}

}
