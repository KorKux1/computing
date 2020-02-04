package com.icesi.computacion.semana2.clase2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Component
@Log
public class PostProcessorBean implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		if (bean.getClass().getPackage().toString().equals("package com.icesi.computacion.semana2.clase2")) {
			log.info("Mi bean " + beanName);
		}
		//return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		if(!(bean.getClass().getPackage().toString().equals("package com.icesi.computacion.semana2.clase2"))) {
			log.info("Bean de Spring: " + beanName);
		}
		//return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
		return bean;
	}
	
}
