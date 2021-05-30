package com.ecommerce.exception;
public class QuantityNotAvailable extends Exception {

	private static final long serialVersionUID = 1L;

	public QuantityNotAvailable(String message) {
		super(message);
	}
}
