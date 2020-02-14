/**
 * 
 */
package com.icesi.computacion.semana4.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.icesi.computacion.semana4.model.Person;
import com.icesi.computacion.semana4.repository.PersonRepositoryImp;


/**
 * @author KorKux
 *
 */
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
