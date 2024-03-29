package com.example.staff.payload;

import java.util.List;

public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private String refreshToken;
	private String username;
	private List<String> roles;

	public JwtResponse(String accessToken, String refreshToken, String username, List<String> roles) {
		this.token = accessToken;
		this.refreshToken = refreshToken;
		this.username = username;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}
	
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	public String getRefreshToken() {
	    return refreshToken;
	  }

	public void setRefreshToken(String refreshToken) {
	    this.refreshToken = refreshToken;
	  }
}
