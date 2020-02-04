package com.icesi.computacion.semana2.clase2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;




@SpringBootApplication()
public class LifeCycleApplication {
	
	private static MyBeanY beanY;
	private static MyBeanY beanY2;
	
	public static void main(String[] args) {
		//SpringApplication.run(LifeCycleApplication.class, args);
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(LifeCycleApplication.class);
		LifeCycleApplication lifeCycleApplication = ctx.getBean(LifeCycleApplication.class);
		beanY = (MyBeanY) ctx.getBean(MyBeanY.class);
		beanY2 = (MyBeanY) ctx.getBean(MyBeanY.class);
		beanY.printMessage();
		beanY2.printMessage();
		ctx.close();
	}
	
/*	public LifeCycleApplication(MyBeanY beanY) {
		this.beanY = beanY;
		this.beanY2 = beanY2;
	}*/
}
