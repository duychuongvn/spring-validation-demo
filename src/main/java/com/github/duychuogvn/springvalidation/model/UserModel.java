package com.github.duychuogvn.springvalidation.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.github.duychuogvn.springvalidation.validator.Phone;

public class UserModel implements Serializable{

	private static final long serialVersionUID = 1L;
	@NotBlank
	@Size(min = 1, max=20)
	private String name;
	@NotBlank
	@Email
	private String email;
	
	@Phone
	private String phone;
	@Pattern(regexp="^[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}$")
	
	@NotNull
	private String dob;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
}
