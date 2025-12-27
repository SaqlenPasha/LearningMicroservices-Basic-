package com.microservice.loans.service;

import com.microservice.loans.dto.LoansDto;


public interface LoansService {

	 void createLoan(String mobileNumber);

    LoansDto fetchLoan(String mobileNumber);

    boolean updateLoan(LoansDto loansDto);

    boolean deleteLoan(String mobileNumber);
	
}
