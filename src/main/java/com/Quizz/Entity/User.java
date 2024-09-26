package com.Quizz.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User {
	@Id
	int userId;
	String userName;
	String email;
	String mobileNo;
	String password;
	String role;
	public User() {
		
	}

	public User(int userId, String userName, String email, String mobileNo, String password, String role) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.role = role;
		this.password = password;

	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
