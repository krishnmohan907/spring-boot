package repository;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdatajpa.springboot.entity.Product;
import com.springdatajpa.springboot.repository.Productrepository;

@SpringBootTest

public class ProductrepositaryTest {

	@Autowired
	private Productrepository productrepo;
	
	@Test
	void saveMethod() {
		//create product object
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
}
