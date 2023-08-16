package com.springdatajpa.springboot;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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

//		 saveUpdate();
		// updataUsingSaveMethod();
		// findById();
		// saveAllMethods();
		// findAllMethods();
		// delete();
		// deleteAll()
		// existById();
		// count()
//		findByName("product 2");
//		findById(1L);
//		findByNameAndDescription("apple","updated product");
//		findByNameorDescription("product 2", "description");
//		findDistinctByName("apple");
//		findByPriceLessThan(new BigDecimal(100));
//		findByPriceGreaterThan(new BigDecimal(100));
//		findByNameContaining("apple");
//		findByNameorDescriptionJPQLIndexParam("apple","updated product");
		
//		findByNameorDescriptionJPQLNamedParam("apple","updated product");
		
//		findAllOrderNameDesc();
	}
	
	   void findAllOrderNameDesc() {
		// TODO Auto-generated method stub
		   
		   List<Product> namedparameter = productrepo.findAllOrderNameDesc();
		   
		   System.out.println("named parameter " +namedparameter );
		
	}

	void findByNameorDescriptionJPQLNamedParam(String name, String descriptions) {
			Product pro = productrepo.findByNameorDescriptionJPQLNamedParam(name, descriptions);
			
			System.out.println("pro description value"  +pro);
		
	}

	void findByNameorDescriptionJPQLIndexParam(String name, String descriptions) {
		Product pro = productrepo.findByNameorDescriptionJPQLIndexParam(name, descriptions);
		
		System.out.println("pro description value"  +pro);
		
	}

	void findByNameContaining(String name) {
		List<Product> productcontain = productrepo.findByNameContaining(name);
		System.out.println("containig value like" + productcontain);
	}

	 void findByPriceLessThan(BigDecimal i) {
		List<Product> pgre = productrepo.findByPriceGreaterThan(i);
		System.out.println("price graterthan" + pgre);
		
	}

	 void findByPriceGreaterThan(BigDecimal i) {
		 List<Product> pgless = productrepo.findByPriceLessThan(i);
		 System.out.println("price lessthan" + pgless);
		
	}

	void findDistinctByName(String name) {
		Product pdec = productrepo.findDistinctByName(name);
		System.out.println("description find by value" + pdec);

	}

	void findByName(String name) {
		Product product = productrepo.findByName(name);
		System.out.println("find by name" + product);
	}

	void findById(long id) {
		Optional<Product> product = productrepo.findById(id);
		System.out.println("find by id is optional" + product);
	}

	void findByNameAndDescription(String name, String description) {
		List<Product> p1 = productrepo.findByNameAndDescription(name, description);

		System.out.println("product name and description" + p1);

	}

	void findByNameorDescription(String name, String description) {

		List<Product> p2 = productrepo.findByNameOrDescription(name, description);
		System.out.println("find or descriptin name" + p2);

	}

	void saveUpdate() {
		// save product
		// display product information
		Product product = new Product();
		product.setName("product 3");
		product.setDescription("product 1 description");
		product.setSku("22315");
		product.setPrice(new BigDecimal(100));
		product.setImage_url("proddect png.1");
		product.setActive(true);

		Product saveobject = productrepo.save(product);

//		display product key

		System.out.println(saveobject.getId());
		System.out.println(saveobject.toString());
	}

	void updataUsingSaveMethod() {

		// find or retrieve on entity by id

		Long id = 1L;
		Product productupdate = productrepo.findById(id).get();
		productupdate.setName("apple");
		productupdate.setDescription("updated product");
		productrepo.save(productupdate);

		// update entity information

		// save updated entity

	}

	void findById() {
		Long id = 1L;
		Optional<Product> productfind = productrepo.findById(id);
		System.out.println("find by ID" + productfind);
	}

	void saveAllMethods() {
		Product product2 = new Product();
		product2.setName("product 2");
		product2.setDescription("product 2 description");
		product2.setSku("100ACBd");
		product2.setPrice(new BigDecimal(200));
		product2.setImage_url("proddect png.2");
		product2.setActive(true);

		Product product3 = new Product();
		product3.setName("product 3");
		product3.setDescription("product 3 description");
		product3.setSku("100ACBaf");
		product3.setPrice(new BigDecimal(200));
		product3.setImage_url("proddect png.2");
		product3.setActive(true);

		productrepo.saveAll(List.of(product2, product3));
	}

	void findAllMethods() {

		List<Product> P = productrepo.findAll();
		P.forEach((p) -> {
			System.out.println("find all methods" + p);
		});

	}

}
