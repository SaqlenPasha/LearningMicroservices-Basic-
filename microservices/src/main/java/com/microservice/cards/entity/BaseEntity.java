package com.microservice.cards.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

	@CreatedBy
	@Column(updatable = false)
	private String createdBy;

	@Column(insertable = false)
	@LastModifiedBy
	private String updatedBy;

	@Column(updatable = false)
	@CreatedDate
	private String createdDate;

	@Column(insertable = false)
	@LastModifiedDate
	private String updatedDate;
}
