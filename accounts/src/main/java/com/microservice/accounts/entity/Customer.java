package com.microservice.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Customer extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	@Size(min=2, message="Name should have at least 2 characters")
	private String customerName;
	
	@Email(message="Email should be valid")
	private String email;
	
	@Size(min=10, max=10, message="Mobile number should be 10 digits")
	private String mobileNumber;

}
