package com.ecommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.UserDto;
import com.ecommerce.exception.CustomException;
import com.ecommerce.exception.ErrorResponse;
import com.ecommerce.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	/**
	 * 
	 * @author ashan
	 * @since 23-05-2021
	 * 
	 *        In this Functionality I trying save a user details
	 * 
	 * @param UserDto
	 * @return UserDto
	 */
	@PostMapping()
	public UserDto saveCustomer(@Valid @RequestBody UserDto userDto) {
		userService.saveCustomer(userDto);
		return userDto;
	}
	
	
	/**
	 * 
	 * @author ashan
	 * @since 23-05-2021
	 * 
	 *        In this Functionality I trying to login user email and password
	 * 
	 * @param userId
	 * @param email 
	 * @param password   
	 * @return String message
	 * @return
	 */
	 @PostMapping("/login")
	    public ErrorResponse customerLogin(@RequestParam String userName,@RequestParam String password) throws CustomException {
	    	 return userService.userLogin(userName,password);
	    	 
	    	// return ResponseEntity<ErrorResponse>(HttpStatus.ACCEPTED);
	    	 
	    }

}
