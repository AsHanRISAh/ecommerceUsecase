package com.ecommerce.exception;








import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	/*
	 * @ExceptionHandler(UserNotLoginException.class) public
	 * ResponseEntity<ErrorResponse> userNotLoginException(UserNotLoginException ex)
	 * {
	 * 
	 * ErrorResponse errorResponse = new ErrorResponse();
	 * 
	 * errorResponse.setMessage(ex.getMessage());
	 * errorResponse.setStatus(UserUtility.USER_NOT_LOGIN_STATUS);
	 * 
	 * return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	 * 
	 * }
	 */

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> customException(CustomException ex) {

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(UserUtility.PRODUCT_NOT_EXIST_STATUS);

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

	}

	 
}