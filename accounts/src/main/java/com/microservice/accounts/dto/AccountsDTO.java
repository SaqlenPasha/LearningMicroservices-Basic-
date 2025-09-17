package com.microservice.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
@Schema(description = "Details about the account")
public class AccountsDTO {
	
	@Schema(description = "Account number", example = "1234567890")
	private Long accountNumber;
	
	@Schema(description = "Account type", example = "Savings")
	private String accountType;
	
	@Schema(description = "Account balance", example = "1000.00")
	private String branchAddress;
}
