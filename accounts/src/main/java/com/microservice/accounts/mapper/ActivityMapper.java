package com.microservice.accounts.mapper;

import com.microservice.accounts.dto.AccountsDTO;
import com.microservice.accounts.entity.Accounts;

public class ActivityMapper {

	
	@SuppressWarnings("unused")
	private static AccountsDTO mapToAccountsDTO(Accounts accounts, AccountsDTO accountsDTO) {
		
		accountsDTO.setAccountNumber(accounts.getAccountNumber());
		accountsDTO.setAccountType(accounts.getAccountType());
		accountsDTO.setBranchAddress(accounts.getBranchAddress());
		
		return accountsDTO;
		
	}
	
	private static Accounts mapToAccounts(AccountsDTO accountsDTO, Accounts accounts) {
		
		accounts.setAccountNumber(accountsDTO.getAccountNumber());
		accounts.setAccountType(accountsDTO.getAccountType());
		accounts.setBranchAddress(accountsDTO.getBranchAddress());
		
		return accounts;
	}
	
}
