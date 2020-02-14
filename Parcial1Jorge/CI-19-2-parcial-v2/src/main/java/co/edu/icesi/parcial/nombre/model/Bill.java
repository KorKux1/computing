package co.edu.icesi.parcial.nombre.model;

import org.springframework.context.annotation.Scope;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
@Scope("prototype")
public class Bill {
	
	@NonNull
	private String id;
	
	@NonNull
	private String firstName;
	
	@NonNull
	private String lastName;
}
