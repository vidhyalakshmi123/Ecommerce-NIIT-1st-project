package com.niit.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int UserId;
	@NonNull
	String username;
	@NonNull
	String mobilenumber;
	@NonNull
	String email;
	@NonNull
	String password;
	private boolean enabled;
	@OneToOne(mappedBy="user")
	private Customer customer;
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	private Authorities authorities;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Authorities getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Authorities authorities) {
		this.authorities = authorities;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
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
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
