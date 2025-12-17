package com.microservice.loans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.loans.entity.Loans;

@Repository
public interface LoansRepository extends JpaRepository<Loans,Long>{

	
	
}
