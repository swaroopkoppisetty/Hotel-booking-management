package com.cap.sprint.hbms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Details about User")
@Table(name="UserTable")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "userId")
public class User {
	@Id
	

	@ApiModelProperty(notes = "User id for booking")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@ApiModelProperty(notes = "Name of the User")
	private String userName;
	@ApiModelProperty(notes = "Email of User")
	@Pattern(regexp = "^(.+)@(.+)$", message = "Provide valid email")
	private String email;
	
	@ApiModelProperty(notes = "Password of User")
//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}[]:;<>,.?/~_+-=|\\]).{8,32}$", message = "Provide valid password")
	private String password;
	
	@ApiModelProperty(notes = "Role of User")
	private String role;
	@ApiModelProperty(notes = "Contact Details of User")
	@Pattern(regexp = "^[7-9][0-9]{9}$", message = "Numbers only")
	@Size(min = 10, max = 10, message = "Mobile Number should be 10 digits")
	private String mobile;
	
	@ApiModelProperty(notes = "Address of User")
	private String address;
	
	public User() {
	}


	
	public User(String userName, String email, String password, String role, String mobile, String address) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.mobile = mobile;
		this.address = address;
	}
	
	public User(int userId, String userName, String email, String password, String role, String mobile,
			String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.mobile = mobile;
		this.address = address;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", role=" + role + ", mobile=" + mobile + ", address=" + address + "]";
	}






	
	
}

	
	



	