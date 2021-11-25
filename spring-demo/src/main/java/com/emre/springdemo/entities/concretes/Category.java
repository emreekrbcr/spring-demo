package com.emre.springdemo.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
@Entity

//Bu alttaki anno. Eager loading'i engellemek için konfigürasyon sanırım, bu entity'lerin altına tanımladığımız
//ilişkilerde sonsuza kadar birbirinin içine girmesin bizim söylediğimiz kadarını map etsin diye

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryID")
	private int id;
	
	@Column(name = "CategoryName")
	private String categoryName;
	
	@OneToMany(mappedBy = "category")
	private List<Product> products;
	
}
