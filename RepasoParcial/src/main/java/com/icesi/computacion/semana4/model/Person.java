/**
 * 
 */
package com.icesi.computacion.semana4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author KorKux
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	@NonNull
	public String firstName;
	@NonNull
	public String lastName;
}
