package com.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.OrderProductDto;
import com.ecommerce.dto.ProductsDto;
import com.ecommerce.dto.ResponseDto;
import com.ecommerce.entity.Products;
import com.ecommerce.exception.CustomException;
import com.ecommerce.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	
	
	
	/**
	 * 
	 * @author ashan
	 * @since 28-05-2021
	 * 
	 *        In this Functionality I trying to search a product
	 * 
	 * @param productName
	 * @param categoryName
	 * @throws customException
	 * @return products
	 */
	@GetMapping("/products")
	public ResponseEntity<ProductsDto> getProducts(@RequestParam String productName, @RequestParam String categoryName)throws CustomException
	{
		logger.info("fetch by product and categoryName");
		return productService.getProducts(productName,categoryName);
	}

	
	/**
	 * 
	 * @author ashan
	 * @since 28-05-2021
	 * 
	 *        In this Functionality I trying to buy a product
	 * 
	 * @requestBody orderProductDto
	 * @throws customException
	 * 
	 */
	@PostMapping("order")
	public String buyproduct(@RequestBody OrderProductDto orderProductDto ) throws CustomException
	{
		logger.info("successfull");
		return productService.buyProduct(orderProductDto);
	}
}
