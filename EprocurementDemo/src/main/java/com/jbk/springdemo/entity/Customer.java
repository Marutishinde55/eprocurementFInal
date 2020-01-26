package com.jbk.springdemo.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull(message = "is required")
	@NotEmpty(message = "is required")
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull(message = "is required")
	@NotEmpty(message = "is required")
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull(message = "is required")
	@NotEmpty(message = "is required")
	@Column(name = "email")
	private String email;
	
	@NotNull()
	@NotEmpty(message = "is required")
	@Column(name = "username")
	private String userName;
	
	@NotNull
	@Column(name = "password")
	private String password;
	
	@Column(name = "gender")
	private String gender;
	
	@NotNull(message = "is required")
	@Size(min = 10,max = 10,message = "enter valid mobile number")
	@Column(name = "Mobileno")
	private String mobileNo;
	

	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Customer() {
		System.out.println("in no argument constructor");
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userName=" + userName + ", password=" + password + ", gender=" + gender + "]";
	}
	
	
}
