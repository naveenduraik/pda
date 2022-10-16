package com.phonedirectory.app.model;

import java.io.Serializable;

public class JWTResponse implements Serializable {

	private final String jwttoken;


	public JWTResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}
