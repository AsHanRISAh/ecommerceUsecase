package com.ecommerce.feighClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.dto.TransferDto;


@FeignClient(name="http://bank/payment/bank")
public interface TransferFeignClientService {

	@PostMapping("customer/account")
	public String buyProduct(TransferDto transferDto);

}
