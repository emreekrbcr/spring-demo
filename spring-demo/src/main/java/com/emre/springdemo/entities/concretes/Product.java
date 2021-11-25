package com.emre.springdemo.entities.concretes;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
@Entity

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductID")
	private int id;

	//Aşağı ilişki tanımladığımız için artık gerek yok
//	@Column(name = "CategoryID")
//	private Integer categoryId; //veritabaninda int ve nullable gecmisler ondan dolayi Integer

	@Column(name = "ProductName")
	private String productName;

	@Column(name = "UnitPrice")
	private BigDecimal unitPrice;

	@Column(name = "UnitsInStock")
	private Integer unitsInStock;

	@Column(name = "QuantityPerUnit")
	private String quantityPerUnit;
	
	@ManyToOne()
	@JoinColumn(name = "CategoryID")
	private Category category;
}
