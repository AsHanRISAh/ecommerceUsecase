package com.ecommerce.service.impl;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.UserDto;
import com.ecommerce.entity.User;
import com.ecommerce.exception.CustomException;
import com.ecommerce.exception.ErrorResponse;
import com.ecommerce.exception.UserUtility;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;

	/**
	 * 
	 * @author ashan
	 * @since 13-05-2021
	 * 
	 *        In this Functionality I trying save a user details
	 * 
	 * @param customerDto
	 * @return
	 */
	
	@Override
	public UserDto saveCustomer(UserDto userDto) {
		User user =new User();
		BeanUtils.copyProperties(userDto, user);
		User customerCheck =userRepository.findByUserName(user.getUserName());
		
		userRepository.save(user);
		logger.info("customer saved successfully");
		return userDto;
		// TODO Auto-generated method stub
		
		
	}
	 /**
		 * 
		 * @author ashan
		 * @since 23-05-2021
		 * 
		 *        In this Functionality I trying to login user username and password
		 * 
		 * @param userId
		 * @param username 
		 * @param password   
		 * @return String message
		 * @return
		 */
		@Override
		public ErrorResponse userLogin(String userName, String password) throws CustomException{
			// TODO Auto-generated method stub
			User user=userRepository.findByUserNameAndPassword(userName,password);
			ErrorResponse response=new ErrorResponse();
			if(user!=null)
			{
				response.setMessage(UserUtility.USER_NOT_EXIST);
				response.setStatus(UserUtility.USER_NOT_EXIST_STATUS);
				return response ;
			}
			response.setMessage("login succesully");
			return response;
		}


}
