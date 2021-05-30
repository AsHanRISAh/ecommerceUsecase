package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ecommerce.dto.ProductsDto;
import com.ecommerce.entity.Products;
import com.ecommerce.entity.User;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{

	@Query("Select p from Products p where p.productName like %:productName% or p.categoryName like%:categoryName")
	ResponseEntity<ProductsDto> findByProductNameAndCategoryName(String productName, String categoryName);

}
