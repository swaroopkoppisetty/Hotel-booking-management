package cap.sprint.capsprinthbms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="UserTable")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "userId")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int userId;
	String userName;
	String email;
	String role;
	String mobile;
	String address;
	
	
	
	
	public User() {
		super();
	}

	public User(int userId, String userName, String email, String role, String mobile, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.role = role;
		this.mobile = mobile;
		this.address = address;
	}


	public User(String userName, String email, String role, String mobile, String address) {
		super();
		this.userName = userName;
		this.email = email;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", role=" + role + ", mobile="
				+ mobile + ", address=" + address + "]";
	}


}
