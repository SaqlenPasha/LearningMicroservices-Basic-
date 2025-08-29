package com.microservice.accounts.entity;

import com.microservice.accounts.dto.CustomerDTO;

public class CustomerMapper {

	public static Customer mapToCustomer(CustomerDTO customerDto, Customer customer) {
		customer.setCustomerName(customerDto.getCustomerName());
		customer.setEmail(customerDto.getEmail());
		customer.setMobileNumber(customerDto.getMobileNumber());
		return customer;
	}
	
	public static CustomerDTO mapToCustomerDTO(Customer customer, CustomerDTO customerDto) {
		customerDto.setCustomerName(customer.getCustomerName());
		customerDto.setEmail(customer.getEmail());
		customerDto.setMobileNumber(customer.getMobileNumber());
		return customerDto;
	}
	
}
