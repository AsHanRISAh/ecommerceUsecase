package com.ecommerce.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.OrderHistoryDto;
import com.ecommerce.dto.OrderProductDto;
import com.ecommerce.dto.ResponseDto;
import com.ecommerce.entity.OrderDetails;
import com.ecommerce.entity.OrderProduct;
import com.ecommerce.entity.Products;
import com.ecommerce.repository.OrderDetailsRepository;
import com.ecommerce.repository.OrderproductRepository;
import com.ecommerce.repository.ProductsRepository;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.ProductService;

@Service
public class OrderServiceImpl implements OrderService{
	
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	ProductsRepository productsRepository;
	@Autowired
	OrderproductRepository orderProductRepository;
	
	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	/*
	 * @Override public String buyProduct(OrderProductDto orderProductDto) { // TODO
	 * Auto-generated method stub
	 * 
	 * OrderProduct order = new OrderProduct();
	 * 
	 * BeanUtils.copyProperties(orderProductDto, order);
	 * 
	 * orderProductRepository.save(order);
	 * 
	 * return "Order placed succesfully"; }
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
	@Override
	public OrderHistoryDto getHistory(Long userId) {
		// TODO Auto-generated method stub
		OrderHistoryDto history=new OrderHistoryDto();
		List<OrderHistoryDto> list=new ArrayList();
		List<ResponseDto> responseDto = new ArrayList<>();
		List<OrderProduct> orderList=orderProductRepository.findByUserId(userId);
		for(OrderProduct order: orderList)
		{
			BeanUtils.copyProperties(order, history);
			List<OrderDetails> orderDetails=orderDetailsRepository.findByOrderId(order.getOrderId());
			for(OrderDetails orderDet : orderDetails)
			{
				ResponseDto response=new ResponseDto();
				Optional<Products> products=productsRepository.findById(orderDet.getProductId());
				BeanUtils.copyProperties(products, response);
				responseDto.add(response);
			}
			history.setResponseDto(responseDto);
		}
		logger.info("order history");
		return history;
	}
		
}
