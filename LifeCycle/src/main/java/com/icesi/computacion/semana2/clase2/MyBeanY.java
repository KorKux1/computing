package com.icesi.computacion.semana2.clase2;


import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;


@Lazy
@Component
@Log
@Scope("prototype")
public class MyBeanY {
	
	public void printMessage() {
		log.info("Work!");
	}
}
