package com.springdatajpa.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpa.springboot.entity.Order;

public interface OrderRepositary extends JpaRepository<Order, Long> {
	
//	Order findByOrderTrackingNumber(String ordertrackingnumber);

}
