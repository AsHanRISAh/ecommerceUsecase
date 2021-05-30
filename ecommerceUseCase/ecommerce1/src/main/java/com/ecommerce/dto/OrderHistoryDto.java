package com.ecommerce.dto;

import java.util.List;

public class OrderHistoryDto {
	private Long orderId;
	private Double totalPrice;
	private List<ResponseDto> responseDto;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<ResponseDto> getResponseDto() {
		return responseDto;
	}
	public void setResponseDto(List<ResponseDto> responseDto) {
		this.responseDto = responseDto;
	}
	
	
	

}
