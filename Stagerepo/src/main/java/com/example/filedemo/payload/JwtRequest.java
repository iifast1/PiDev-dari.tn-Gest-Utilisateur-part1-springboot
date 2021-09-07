package com.example.filedemo.payload;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class JwtRequest implements Serializable {

private static final long serialVersionUID = 5926468583005150707L;
	
	private String token;
	private String username;
	private String password;
	private String Tel;
	private String email;
	private String image;
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public JwtRequest(String token, String username, String password, String tel, String email, String image) {
		super();
		this.token = token;
		this.username = username;
		this.password = password;
		Tel = tel;
		this.email = email;
		this.image = image;
	}

	public JwtRequest() {
		 
	}

	
	
	
}
