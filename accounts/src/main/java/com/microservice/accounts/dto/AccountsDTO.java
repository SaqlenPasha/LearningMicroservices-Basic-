package com.microservice.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
public class AccountsDTO {
	
	private Long accountNumber;
	
	private String accountType;
	
	private String branchAddress;
}
