package com.springdatajpa.springboot;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springdatajpa.springboot.entity.Address;
import com.springdatajpa.springboot.entity.Order;
import com.springdatajpa.springboot.repository.OrderRepositary;


@SpringBootApplication
public class OrderAddress implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaCourseApplication.class, args);
	}

	@Autowired
	OrderRepositary orderrepo;
	@Override
	public void run(String... args) throws Exception {
//		saveOrderAddress();
//		updateOrderAddress();
//		deleteOrder();
		
	}
	
	void saveOrderAddress() {
		
		Order order = new Order();
		order.setTotalQuantity(10);
		order.setOrderTrackingNumber("1000");
		order.setStatus("true");
		order.setTotalPrice(new BigDecimal(100));
		order.setTotalQuantity(100);
		
		Address ad = new Address();
		
		ad.setCity("hyd");
		ad.setCountry("india");
		ad.setState("AP");
		ad.setStreet("Skyla");
		ad.setZipcode("533432");
		order.setBillingAddress(ad);
		
		
		
		orderrepo.save(order);
	
		
		
	}
	
	void updateOrderAddress() {
		
		Order order = orderrepo.findById(1l).get();
		
		order.setStatus("false");
		
		order.getBillingAddress().setCity("BNG");
		
		
		
		orderrepo.save(order);
	
	}
	
	void deleteOrder() {
		
		orderrepo.deleteById(1L);
	}

}
