package com.icesi.computacion.semana2.clase2;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;




@SpringBootApplication
public class LifeCycleApplication {
	
	public static void main(String[] args) {
		//SpringApplication.run(LifeCycleApplication.class, args);
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(LifeCycleApplication.class);
		ctx.close();
	}


}
