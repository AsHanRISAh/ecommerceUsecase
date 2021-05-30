package com.ecommerce.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.controller.ProductController;
import com.ecommerce.dto.OrderProductDto;
import com.ecommerce.dto.ProductsDto;
import com.ecommerce.dto.ResponseDto;
import com.ecommerce.dto.TransferDto;
import com.ecommerce.entity.OrderDetails;
import com.ecommerce.entity.OrderProduct;
import com.ecommerce.entity.Products;
import com.ecommerce.exception.CustomException;
import com.ecommerce.exception.ErrorResponse;
import com.ecommerce.exception.UserUtility;
import com.ecommerce.feighClient.TransferFeignClientService;
import com.ecommerce.repository.OrderDetailsRepository;
import com.ecommerce.repository.OrderproductRepository;
import com.ecommerce.repository.ProductsRepository;
import com.ecommerce.service.ProductService;

@Service
public class ProductsServiceImpl implements ProductService {

	
	private static final Logger logger = LoggerFactory.getLogger(ProductsServiceImpl.class);
	
	@Autowired
	ProductsRepository productsRepository;
	
	@Autowired
	TransferFeignClientService transferFeignClientService;
	
	@Autowired
	OrderproductRepository orderProductRepository;
	
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	
	
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
	@Override
	public ResponseEntity<ProductsDto> getProducts(String productName, String categoryName)throws CustomException {
		// TODO Auto-generated method stub
		ResponseEntity<ProductsDto> pro=productsRepository.findByProductNameAndCategoryName(productName,categoryName);
		if(pro!=null)
		{
			logger.info("success");
		return pro;
		}
		ErrorResponse error =new ErrorResponse();
		error.setMessage(UserUtility.PRODUCT_NOT_EXIST);
		error.setStatus(UserUtility.PRODUCT_NOT_EXIST_STATUS);
		logger.error("noProductException");
		throw new CustomException(UserUtility.PRODUCT_NOT_EXIST);
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
	@Override
	public String buyProduct(OrderProductDto orderProductDto)throws CustomException {
		// TODO Auto-generated method stub
		//List<OrderProductDto> orderResponse=new ArrayList<>();
		List<ResponseDto> responseDto=new ArrayList<>();
		double totalPrice=0.0;
		//ProductsDto productDto=new ProductsDto();

		try {
		List<Long> check = new ArrayList<>(orderProductDto.getProductId());
		for(Long id :check) {
			Optional<Products> products=productsRepository.findById(id);
			totalPrice+=products.get().getPrice();
			logger.info("totalPrice" + totalPrice);
			  ResponseDto response=new ResponseDto();
			  BeanUtils.copyProperties(products.get(), response);
	     responseDto.add(response);
		}
		
		TransferDto transferDto = new TransferDto();
		transferDto.setAmount(totalPrice);
		transferDto.setFromAccount(orderProductDto.getAccountNumber());
		logger.info("transfer to dummy service");
		String transfer = transferFeignClientService.buyProduct(transferDto);
		OrderProduct orderProduct= new OrderProduct();
		orderProduct.setUserId(orderProductDto.getUserId());
		orderProduct.setTotalPrice(totalPrice);
		orderProductRepository.save(orderProduct);
		logger.info("orderProduct saved");
		for(Long id:check) {
			Optional<Products> products=productsRepository.findById(id);
			OrderDetails orderDetails=new OrderDetails();
			orderDetails.setOrderId(orderProduct.getOrderId());
			BeanUtils.copyProperties(products.get(), orderDetails);
			orderDetailsRepository.save(orderDetails);
			logger.info("orderDetails saved");
		}
		logger.info("order successfull");
		return "order successfull";
		}
		catch(Exception e) {
			//ErrorResponse error =new ErrorResponse();
			//error.setMessage(UserUtility.BOUGHT_UNSUCCESSSFULL);
			//error.setStatus(UserUtility.BOUGHT_UNSUCCESSSFUL_STATUS);
			logger.error("no order");
			throw new CustomException(UserUtility.BOUGHT_UNSUCCESSSFULL);
		}
}
}

