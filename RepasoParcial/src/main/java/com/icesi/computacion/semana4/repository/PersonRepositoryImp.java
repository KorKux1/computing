package com.icesi.computacion.semana4.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.icesi.computacion.semana4.model.Person;

public class PersonRepositoryImp implements PersonRepository{

	HashMap<String, Person> persons = new HashMap<String, Person>();
	
	@Override
	public Person getPerson(String lastName) {
		return persons.get(lastName);
	}

	@Override
	public void savePerson(Person person) {
		persons.put(person.lastName, person);
	}

	@Override
	public boolean removePerson(String lastName) {
		return persons.remove(lastName, getPerson(lastName));
	}

	@Override
	public void updatePerson(String lastName, Person person) {
		Person updated = getPerson(lastName);
		updated = person;
	}

}
