package com.microservice.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.accounts.dto.CustomerDTO;
import com.microservice.accounts.dto.ErrorDetailsDTO;
import com.microservice.accounts.dto.ResponseDTO;
import com.microservice.accounts.service.AccountsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1")
@Tag(name = " Accounts Controller", description = "APIs for Accounts Microservice")
public class AccountsController {

	@Autowired
	private AccountsService accountsService;

	@Operation(summary = "Get Accounts Home", description = "API to get Accounts Home")
	@ApiResponse(responseCode = "200", description = "Successfully retrieved Accounts Home")
	@GetMapping("/accounts")
	public String accounts() {
		return "accounts";
	}

	@Operation(summary = "Create Account", description = "API to create a new account")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Account created successfully"),
			@ApiResponse(responseCode = "500", description = "Internal server error"),
			@ApiResponse(responseCode = "409", description = "Account already exists"),
			@ApiResponse(responseCode = "400", description = "Bad Request", 
							content = @Content(schema = @Schema(implementation = ErrorDetailsDTO.class))) })
	@PostMapping("/createAccount")
	public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO customer) {

		accountsService.createAccount(customer);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDTO("Success", "Account created successfully"));
	}

	@Operation(summary = "Update Account", description = "API to Update a account")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Account Updated successfully"),
			@ApiResponse(responseCode = "500", description = "Internal server error"),
			@ApiResponse(responseCode = "400", description = "Resource Not Found") })
	@PutMapping("/updateAccount")
	public ResponseEntity<ResponseDTO> updateAccount(@Valid @RequestBody CustomerDTO customer) {

		accountsService.updateAccount(customer);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO("Success", "Account Updated successfully"));
	}

	@Operation(summary = "Delete Account", description = "API to delete an account")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Account Updated successfully"),
			@ApiResponse(responseCode = "500", description = "Internal server error"),
			@ApiResponse(responseCode = "400", description = "Resource Not Found") })
	@DeleteMapping("/deleteAccount")
	public ResponseEntity<ResponseDTO> deleteAccount(@RequestParam("mobile") String mobileNumber) {

		accountsService.deleteAccount(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO("Success", "Account Deleted successfully"));
	}

}
