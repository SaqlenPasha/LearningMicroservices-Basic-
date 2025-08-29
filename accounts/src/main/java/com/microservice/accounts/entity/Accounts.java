package com.microservice.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
public class Accounts extends BaseEntity {

	@Id
	private Long accountNumber;

	private Long customerId;
	
	private String accountType;
	
	private String branchAddress;
	
}
