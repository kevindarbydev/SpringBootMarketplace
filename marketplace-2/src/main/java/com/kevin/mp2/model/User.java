package com.kevin.mp2.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;

@Entity
@Table(name = "users")
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "userId")
	private Long userId;
	
	@Column(nullable=false,unique=true,length=45)
	private String email;
	
	@Column(nullable=false,length=100)
	private String password;
	
	@Column(name="name",nullable=false,length=20)
	private String name;
	@Column(nullable = true, length = 64,name = "userImage")
	private String userImage;
	
	

	@Transient
	public String getPhotosImagePath() {
		if (userImage == null || userId == null) return null;
		
		return "/user-photos/" + userId + "/"  + userImage;
	}
	
	

	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}






	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getUserImage() {
		return userImage;
	}



	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", userImage=" + userImage + "]";
	}

	

}
