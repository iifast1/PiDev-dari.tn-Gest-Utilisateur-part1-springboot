package com.example.filedemo.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long iduser;
	//private String nom;
	private String username;
	private String Tel;
	private String email;
//	@Temporal(TemporalType.DATE)
//	private Date datefincontrat;
//	private String nomsociete ;
//	private String gouvernerasociete;
//	private String adresselivraion;
//	private String delgationsociete;
//	private String localitesociete;
//	private int codepostalesociete;
	private String image;
//	private String adresselivraison;
//	private String gouverneralivraison;
//	private String localitelivraison;
//	private String Codepostalelivraision;
//	private float prixlivraision;
//	private float prixretour;
	private String password;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Role> role = new ArrayList<>();

	public long getIduser() {
		return iduser;
	}

	public void setIduser(long iduser) {
		this.iduser = iduser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public User(long iduser, String username, String tel, String email, String image, String password,
			List<Role> role) {
		super();
		this.iduser = iduser;
		this.username = username;
		Tel = tel;
		this.email = email;
		this.image = image;
		this.password = password;
		this.role = role;
	}

	public User() {}
	
	
	
}
