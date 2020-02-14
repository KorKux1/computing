/**
 * 
 */
package com.icesi.computacion.semana4.repository;

import com.icesi.computacion.semana4.model.Person;

/**
 * @author computacion19.2
 *
 */
public interface PersonRepository {
	
	public Person getPerson(String lastName);
	public void savePerson(Person person);
	public boolean removePerson(String lastName);
	public void updatePerson(String lastName, Person person);
	
	
}
