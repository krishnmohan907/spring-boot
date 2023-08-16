package com.springdatajpa.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpa.springboot.entity.Address;

public interface AddressRepositary extends JpaRepository<Address, Long> {

}
