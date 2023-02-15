package com.example.staff.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SignupRequest {

	@NotBlank
    @Size(min = 3, max = 20)
    private String username;
    
    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

}
