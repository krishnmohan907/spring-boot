package com.springdatajpa.springboot;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springdatajpa.springboot.entity.Address;
import com.springdatajpa.springboot.entity.Order;
import com.springdatajpa.springboot.repository.AddressRepositary;

@SpringBootApplication
public class OneToBidirectionalMapping implements CommandLineRunner {
	
	@Autowired
	AddressRepositary addressrepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		saveOrderAddress();
		updateOrderAddress();
		
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
		
		ad.setOrder(order);
		
		addressrepo.save(ad);
	
		
		
	}

void updateOrderAddress() {
	
	Address add = addressrepo.findById(1l).get();
	
	add.setZipcode("121212");
	
	add.getOrder().setStatus("false");
	
	 addressrepo.save(add);

}
	

}
