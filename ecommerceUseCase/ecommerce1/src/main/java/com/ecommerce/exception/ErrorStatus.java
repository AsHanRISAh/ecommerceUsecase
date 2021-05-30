
package com.ecommerce.exception;


public class ErrorStatus {
	int statuscode;
	String statusmessage;

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int notFound) {
		this.statuscode = notFound;
	}

	public String getStatusmessage() {
		return statusmessage;
	}

	public void setStatusmessage(String statusmessage) {
		this.statusmessage = statusmessage;
	}

}