package com.example.staff.payload;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TokenRefreshRequest {

	@NotBlank
	private String refreshToken;
}
