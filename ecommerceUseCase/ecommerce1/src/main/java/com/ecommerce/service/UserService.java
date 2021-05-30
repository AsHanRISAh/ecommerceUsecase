package com.ecommerce.service;

import javax.validation.Valid;

import com.ecommerce.dto.UserDto;
import com.ecommerce.exception.CustomException;
import com.ecommerce.exception.ErrorResponse;

public interface UserService {

	UserDto saveCustomer(@Valid UserDto userDto);

	ErrorResponse userLogin(String userName, String password) throws CustomException;

}
