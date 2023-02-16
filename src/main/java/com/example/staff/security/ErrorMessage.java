package com.example.staff.security;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {

	  private int statusCode;
	  private Date timestamp;
	  private String message;
	  private String description;
}
