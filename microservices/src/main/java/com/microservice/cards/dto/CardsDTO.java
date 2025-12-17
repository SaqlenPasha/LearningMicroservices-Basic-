package com.microservice.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Tags(value = { @Tag(name = "Cards", description = "Cards object for  API") })
public class CardsDTO {

	@NotNull(message = "Card ID cannot be null")
	@Pattern(regexp = "^\\d{10}$", message = "Mobile number must be 10 digits")
	@Schema(description = "Card ID of the card", example = "9837465352")
	private String mobileNumber;

	@NotNull(message = "Card number cannot be null")
	@Pattern(regexp = "^\\d{12}$", message = "Card number must be 16 digits")
	@Schema(description = "Card number of the card", example = "123456789012")
	private String cardNumber;

	@NotNull(message = "Card type cannot be null")
	@Size(min = 6, max = 20)
	@Schema(description = "Type of the card", example = "CREDIT")
	private String cardType;

	@NotNull(message = "Total limit cannot be null")
	@Positive(message = "Total limit must be positive")
	@Schema(description = "Total limit of the card", example = "50000")
	private int totalLimit;

	@NotNull(message = "Amount used cannot be null")
	@PositiveOrZero(message = "Amount used must be gretaer than zero")
	@Schema(description = "Amount used of the card", example = "10000")
	private int amountUsed;

	@NotNull(message = "Available amount cannot be null")
	@PositiveOrZero(message = "Available amount must be gretaer than zero")
	@Schema(description = "Available amount of the card", example = "40000")
	private int availableAmount;

}
