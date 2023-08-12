package com.springdatajpa.springboot.entity;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "products", 
	   schema = "ecommerce",
	   uniqueConstraints = {
		@UniqueConstraint(name = "sku_unique", 
				          columnNames = "stock_keeping_unit"),
		}
)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "stock_keeping_unit",nullable = false)
	private String sku;
	
	@Column(nullable = false)
	private String name;
	private String description;
	private BigDecimal price;
	private boolean active;
	private String image_url;
	
	@CreationTimestamp
	private LocalDateTime date_created;
	
	@UpdateTimestamp
	private LocalDateTime last_Updated;

	
}