package repository;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdatajpa.springboot.entity.Product;
import com.springdatajpa.springboot.repository.Productrepository;

@SpringBootTest
public class NamedQueryTest {
	
	@Autowired
	private Productrepository productrepro;
	
	
	@Test
	void namedJPQLQuery() {
		
		Product product = productrepro.findByPrice(new BigDecimal(100));
		
		System.out.println("description"+product.getDescription());
		System.out.println("name value"+ product.getName());
	}

}
