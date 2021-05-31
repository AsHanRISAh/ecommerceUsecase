package com.ecommerce.bank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.bank.dto.TransferDto;


@RestController
@RequestMapping("/bank")
public class TransferController {
	
	@PostMapping("customer/account")
	public String buyProduct(@RequestBody TransferDto transferDto)
	{
		return "order successfull";
		
	}

}
