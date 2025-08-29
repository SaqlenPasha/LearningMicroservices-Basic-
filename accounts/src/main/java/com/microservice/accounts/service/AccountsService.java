package com.microservice.accounts.service;

import com.microservice.accounts.dto.CustomerDTO;

public interface AccountsService {

	public void createAccount(CustomerDTO customer);
	
	public void updateAccount(CustomerDTO customer);
}
