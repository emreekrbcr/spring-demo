package com.emre.springdemo.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserID")
	private int id;

	@Column(name = "Email")
	//Validationları boyle yazmak cok saglikli degil ama Java community'si %100'e yakin boyle kullaniyormus
	//.Net'deki Fluent Validation gibi popüler bir kütüphane de olmadığı için Javada böyle ilerlencek
	@Email
	@NotBlank
	@NotNull
	@Length(min = 7,max = 30)
	private String email;

	@Column(name = "Password")
	@NotBlank
	@NotNull
	@Length(min = 5,max = 15)
	private String password; //bunu sonradan hashleyip,s tuzlarız simdilik boyle kalsin
}
