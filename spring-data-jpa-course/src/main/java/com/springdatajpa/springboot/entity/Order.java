package com.springdatajpa.springboot.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String OrderTrackingNumber;
	private int totalQuantity;
	private BigDecimal totalPrice;
	private String status;
	@CreationTimestamp
	private LocalDateTime dataCreated;
	@UpdateTimestamp
	private LocalDateTime lastUpdated;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "order")
//	@JoinColumn(name = "billing_address_id",referencedColumnName = "id")
	private Address billingAddress;
	

}
