package com.ecommerce.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ecommerce.dto.OrderProductDto;
import com.ecommerce.dto.ProductsDto;
import com.ecommerce.dto.ResponseDto;
import com.ecommerce.entity.Products;
import com.ecommerce.exception.CustomException;

public interface ProductService {

	ResponseEntity<ProductsDto> getProducts(String productName, String categoryName) throws CustomException;

	String buyProduct(OrderProductDto orderProductDto) throws CustomException;

}
