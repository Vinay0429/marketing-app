package com.marketingapp.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="leads")
public class Lead {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min=2,message="Name should be atleast 2 characters")
	@Column(name="first_name",nullable=false,length=45)
	private String firstName;//first_name
	
	@NotNull
	@Size(min=2,message="Name should be atleast 2 characters")
	@Column(name="last_name",nullable=false,length=45)
	private String lastName;//lats_name
	
	@Email
	@Column(name="email",nullable=false,length=128, unique=true)
	private String email;//email
	
	@NotNull
	@Pattern(regexp="\\d{10}",message="Invalid phone number.It must be exactly 10 digits")
	@Column(name="mobile",nullable=false, unique=true)
	private String mobile;//mobile

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

		
	

}
