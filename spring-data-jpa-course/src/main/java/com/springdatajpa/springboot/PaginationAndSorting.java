package com.springdatajpa.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.springdatajpa.springboot.entity.Product;
import com.springdatajpa.springboot.repository.Productrepository;

@SpringBootApplication
public class PaginationAndSorting implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaCourseApplication.class, args);
	}

	@Autowired
	Productrepository projectrepo;

	@Override
	public void run(String... args) throws Exception {

//		pagination();
//		sorting();
//		groupSorting();
//		paginationAndSorting();
	}

	void pagination() {
		
		int pageNo = 0;
		int size = 5;
		
		//create pageable object
		
		Pageable pageable = PageRequest.of(pageNo, size);
		
		//findAll method and pass the pageable instance
		
		Page<Product> page = projectrepo.findAll(pageable);
		
		List<Product> products = page.getContent();
		
		products.forEach((p) -> {
			System.out.println(p);
		});
		//total pages
		int totalPages = page.getTotalPages();
		//total Number elements
		long totalElements = page.getTotalElements();	
		// number of elements
		int numberElements = page.getNumberOfElements();
		//size
		int size1 = page.getSize();
		// last
		boolean last = page.isLast();
		// first
		boolean first = page.isFirst();
		
		System.out.println("total pages" + totalPages);
		
		System.out.println("totalelements" + totalElements);
		
		System.out.println("numer elemets" + numberElements);
		
		System.out.println("size" + size1);
		
		System.out.println("first element" + last);
		
		System.out.println("last elemts" + first);
		

	}

	void sorting() {
		
		String sortBy ="price";
		String sortDir ="desc";
		
		
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
				Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();
		
		List<Product> productssort = projectrepo.findAll(sort);
		
		productssort.forEach((p) ->{
			
			System.out.println("print the value list" + p);
		});
		
		List<Product> productassending = projectrepo.findAll(Sort.by(sortBy).ascending());
		
		System.out.println("PRODUCT OBJECT" + productssort);
	}
	
	void groupSorting() {
		
		String name ="name";
		String description ="description";
		String sortDir ="desc";
		
		Sort sortName = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
				Sort.by(name).ascending(): Sort.by(name).descending();
		
		Sort Description = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
				Sort.by(description).ascending() : Sort.by(description).descending();
		
		//sorting on Multiple coloums group By sort
		
		Sort groupSort = sortName.and(Description);
		
		List<Product> sortedproduct = projectrepo.findAll(groupSort);
		
		System.out.println("group sorting" + sortedproduct);
		
		
				
				
	}
	
	void paginationAndSorting(){
		
		String name ="price";
		int pageNo1 = 0;
		int pageSize2 =5;
		String sortDir1 ="desc";
		
		Sort sortName = sortDir1.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
				Sort.by(name).ascending(): Sort.by(name).descending();
		
		Pageable page3 = PageRequest.of(pageNo1, pageSize2, sortName);
		
		System.out.println("page and sort" + page3);
		
	}
}
