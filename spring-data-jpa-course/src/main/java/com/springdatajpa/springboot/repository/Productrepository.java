package com.springdatajpa.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpa.springboot.entity.Product;

public interface Productrepository extends JpaRepository<Product, Long> {
 
}
