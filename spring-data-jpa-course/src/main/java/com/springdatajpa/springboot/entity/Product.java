package com.springdatajpa.springboot.entity;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "products", 
	   schema = "ecommerce",
	   uniqueConstraints = {
		@UniqueConstraint(name = "sku_unique", 
				          columnNames = "sku"),
		@UniqueConstraint(name="name_unique",
						  columnNames = "name"
						  )
		}
)
public class Product {

	@Id
	private Long id;
	private String sku;
	private String name;
	private String description;
	private BigDecimal price;
	private boolean active;
	private String image_url;
	private LocalDateTime date_created;
	private LocalDateTime last_Updated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public LocalDateTime getDate_created() {
		return date_created;
	}

	public void setDate_created(LocalDateTime date_created) {
		this.date_created = date_created;
	}

	public LocalDateTime getLast_Updated() {
		return last_Updated;
	}

	public void setLast_Updated(LocalDateTime last_Updated) {
		this.last_Updated = last_Updated;
	}

}