package com.microservice.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {
	
	@Schema(description = "Customer name", example = "John Doe")
	@Size (min = 2, message = "Customer name must have at least 2 characters") 
	private String customerName;

	@Schema(description="Email", example="abc@gmail.com")
	@Email(message = "Email should be valid")
	private String email;
	
	@Schema(description = "Customer mobile number", example = "1234567890")
	@Size(min = 10, max = 10, message = "Mobile number should be 10 digits")
	private String mobileNumber;
	
	private AccountsDTO accounts;
}
