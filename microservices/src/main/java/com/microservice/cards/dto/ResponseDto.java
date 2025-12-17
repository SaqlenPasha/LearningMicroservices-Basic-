package com.microservice.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {

	@Schema(description = "Status of the response")
	private String status;

	@Schema(description = "Message providing additional information about the response" , 
				example = "Given Operation successfully")
	private String message;
}
