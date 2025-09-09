package com.microservice.accounts.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.accounts.dto.CustomerDTO;
import com.microservice.accounts.entity.Accounts;
import com.microservice.accounts.entity.Customer;
import com.microservice.accounts.exception.CustomerExistsException;
import com.microservice.accounts.exception.ResourceNotFound;
import com.microservice.accounts.repository.AccountsRepository;
import com.microservice.accounts.repository.CustomerRepository;
import com.microservice.accounts.service.AccountsService;

@Service
public class AccountsServiceImpl implements AccountsService {

	@Autowired
	private AccountsRepository accountsRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void createAccount(CustomerDTO customer) {

		Customer customerEntity = new Customer();
		customerEntity.setCustomerName(customer.getCustomerName());
		customerEntity.setEmail(customer.getEmail());

		customerEntity.setMobileNumber(customer.getMobileNumber());

		customerRepository.findByMobileNumber(customer.getMobileNumber()).ifPresent(existingCustomer -> {
			throw new CustomerExistsException(
					"Customer with mobile number " + customer.getMobileNumber() + " already exists.");
		});

		Customer savedCustomer = customerRepository.save(customerEntity);

		Accounts account = createAccountObject(savedCustomer);

		accountsRepository.save(account);

	}

	private Accounts createAccountObject(Customer customer) {
		Accounts account = new Accounts();

		Random random = new Random();
		account.setAccountNumber(1000000000L + (long) (random.nextDouble() * 9000000000L));
		account.setAccountType("SAVINGS");
		account.setCustomerId(customer.getCustomerId());
		account.setBranchAddress("HYDERABAD");
		return account;
	}

	@Override
	public void updateAccount(CustomerDTO customer) {

		Customer existingCustomer = customerRepository.findByMobileNumber(customer.getMobileNumber())
				.orElseThrow(() -> new ResourceNotFound(
						"Customer with mobile number " + customer.getMobileNumber() + " does not exist."));

		existingCustomer.setCustomerName(customer.getCustomerName());
		existingCustomer.setEmail(customer.getEmail());

		customerRepository.save(existingCustomer);

	}

	@Override
	public void deleteAccount(String mobileNumber) {

		Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
				() -> new ResourceNotFound("Customer with mobile number " + mobileNumber + " does not exist."));

		customerRepository.delete(customer);

	}

}
