package com.example.filedemo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRole;
	private String role;
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
