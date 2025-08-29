package com.microservice.accounts.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {
	
	@Size (min = 2, message = "Customer name must have at least 2 characters") 
	private String customerName;
	
	@Email(message = "Email should be valid")
	private String email;
	
	@Size(min = 10, max = 10, message = "Mobile number should be 10 digits")
	private String mobileNumber;
}
