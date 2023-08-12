package com.springdatajpa.springboot;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springdatajpa.springboot.entity.Product;
import com.springdatajpa.springboot.repository.Productrepository;

@SpringBootApplication
public class SpringDataJpaCourseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaCourseApplication.class, args);
	}
	
	@Autowired
	Productrepository productrepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
//		saveupdate();
				updataUsingSaveMethod();
				
			}
	
	void saveupdate() {
		//save product 
		//display product information
		Product product = new Product();
		product.setName("product 1");
		product.setDescription("product 1 description");
		product.setSku("100ACB");
		product.setPrice(new BigDecimal(100));
		product.setImage_url("proddect png.1");
		product.setActive(true);
		
		Product saveobject = productrepo.save(product);
		
//		display product key
		
		System.out.println(saveobject.getId());
		System.out.println(saveobject.toString());
	}
	
	void updataUsingSaveMethod() {
		
		//find or retrieve on entity by id
		
		Long id = 1L;
		Product productupdate = productrepo.findById(id).get();
		productupdate.setName("apple");
		productupdate.setDescription("updated product");
		productrepo.save(productupdate);
		
		
		//update entity information
		
		//save updated entity
		
		
	}
		
	

}
