package co.edu.icesi.ci.thymeval.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@NotBlank
	@Size(min=2)
	private String name;
	
	@Email
	@NotBlank
	private String email;
	
	@NotNull
	private UserType type;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@Past
	private LocalDate birthDate;
	
	@NotNull
	private UserGender gender;
	
//	@OneToMany
//	private List<Appointment> appointments;
}
