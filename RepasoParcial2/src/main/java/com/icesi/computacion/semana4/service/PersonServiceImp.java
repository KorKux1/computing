/**
 * 
 */
package com.icesi.computacion.semana4.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.icesi.computacion.semana4.model.Person;
import com.icesi.computacion.semana4.repository.PersonRepositoryImp;


/**
 * @author KorKux
 *
 */
@Service
@Scope("prototype")
public class PersonServiceImp  implements PersonService{
	
	@Autowired
	PersonRepositoryImp personRepository;
	
	@Override
	public boolean removePerson(String lastName) {
		return personRepository.removePerson(lastName);
	}

	@Override
	public void addPerson(String name, String lastName) {
		personRepository.savePerson(new Person(name, lastName));;
	}
	
	
	
}
