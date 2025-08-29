package com.microservice.accounts.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.accounts.dto.CustomerDTO;
import com.microservice.accounts.dto.ResponseDTO;
import com.microservice.accounts.service.AccountsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path="/api/v1")
public class AccountsController {

	@Autowired
	private AccountsService accountsService;
	
    @GetMapping("/accounts")
    public String accounts(){
        return "accounts";
    }
    
    @PostMapping("/createAccount")
    public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO customer){
    	
    	accountsService.createAccount(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO("Success", "Account created successfully"));
	}
    
    @PutMapping("/updateAccount")
    public ResponseEntity<ResponseDTO> updateAccount(@Valid @RequestBody CustomerDTO customer){
    	
    	accountsService.createAccount(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO("Success", "Account created successfully"));
	}

}
