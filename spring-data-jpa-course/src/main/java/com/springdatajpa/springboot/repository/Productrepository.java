package com.springdatajpa.springboot.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springdatajpa.springboot.entity.Product;



public interface Productrepository extends JpaRepository<Product, Long> {

	/**
	 * Return the found product entry using its name as search criteria. if no
	 * product entry is found , this method returns null
	 */

	public Product findByName(String name);

	/**
	 * Return an Optional which contain the found product entry by using id as
	 * search criteria. if no product empty is found, this method returns an empty
	 * Optional
	 */

	Optional<Product> findById(Long id);

	public List<Product> findByNameAndDescription(String name, String description);

	public List<Product> findByNameOrDescription(String name, String description);

	public Product findDistinctByName(String name);

	public List<Product> findByPriceGreaterThan(BigDecimal price);

	public List<Product> findByPriceLessThan(BigDecimal price);

	public List<Product> findByNameContaining(String name);

//	public List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

	// define JPQL query using @Query Annotation with index index position
	// parameter.
	@Query("SELECT p from Product p where p.name = ?1 or p.description =?2")
	Product findByNameorDescriptionJPQLIndexParam(String name, String description);

	// define JPQL query using @Query Annotation with Named parameter
	@Query("SELECT p from Product p where p.name = :name or p.description =:description")
	Product findByNameorDescriptionJPQLNamedParam(@Param("name") String name, @Param("description") String description);

//define Native SQL query using @Query annotation with index or position  parameters

	@Query(value = "SELECT p from Product p where p.name = ?1 or p.description =?2", nativeQuery = true)
	Product findByNameorDescriptionSQLIndexParam(String name, String description);

	// define Native SQL query using @Query annotation with named or position
	// parameters

	@Query(value = "SELECT p from Product p where p.name = :name or p.description =:description", nativeQuery = true)
	Product findByNameorDescriptionSQLNamedParam(@Param("name") String name, @Param("description") String description);

//Define JPQL query
//	Product findByPrice(BigDecimal name);
	
//	//Define JPQL query
//		Product findByPrice(@Param("price") BigDecimal price);

	
	//Define Named JPQL query
	
	Product findByPrice(@Param("price") BigDecimal price);
	List<Product> findAllOrderNameDesc();
	
	
//	//Define Named native SQL query
//	@Query(nativeQuery = true)
//	Product findByDescription(@Param("description") String description);
//	List<Product> findAllOrderByASC();
	
}
