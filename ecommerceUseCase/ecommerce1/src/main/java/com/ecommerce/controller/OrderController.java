package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.OrderHistoryDto;
import com.ecommerce.dto.OrderProductDto;
import com.ecommerce.service.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {
	

	
	  @Autowired 
	  OrderService orderService;
	  
	/*
	 * @PostMapping("/buyproduct") public ResponseEntity<String>
	 * buyproduct(@RequestBody OrderProductDto orderProductDto) { String
	 * message=orderService.buyProduct(orderProductDto); return new
	 * ResponseEntity<>(message, HttpStatus.OK);
	 * 
	 * }
	 */
	  

		/**
		 * 
		 * @author ashan
		 * @since 28-05-2021
		 * 
		 *        In this Functionality I trying to fetch the history of order 
		 * 
		 * @param userId
		 * @return orderDetails
		 */
	  @GetMapping("/order/{userId}")
	  public OrderHistoryDto getHistory(@PathVariable Long userId) {
		  return orderService.getHistory(userId);
	  }
}
