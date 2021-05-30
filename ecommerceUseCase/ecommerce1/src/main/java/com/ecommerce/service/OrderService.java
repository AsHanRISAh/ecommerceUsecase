package com.ecommerce.service;

import com.ecommerce.dto.OrderHistoryDto;
import com.ecommerce.dto.OrderProductDto;

public interface OrderService {

	//String buyProduct(OrderProductDto orderProductDto);

	OrderHistoryDto getHistory(Long userId);

}
