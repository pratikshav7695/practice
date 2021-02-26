package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "user_id")
	private int userId;

	@NotNull
	@Column(name = "user_name",unique = true)
	@Size(min = 3, max = 50, message = "User name must be between 3 and 50 characters")
	private String userName;

	@NotNull 
	@Column(name = "user_email",unique = true)
	@Size(min = 5, max = 50, message = "Enter valid email address")
	/* @Email */
	private String userEmail;

	@NotNull
	@Column(name = "user_password")
	@Size(min = 3, max = 50, message = "User name must be between 3 and 50 characters")
	private String userPassword;

	@NotNull
	@Column(name = "user_phone",unique = true)
	@Size(min = 10, max = 10, message = "User Phone number must be 10 digits")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String userPhone;

	@NotNull
	@Column(name = "user_address")
	@Size(min = 3, max = 100, message = "User Address must be between 3 and 100 characters")
	private String userAddress;

	@NotNull
	@Column(name = "user_role")
	@Size(min = 3, max = 20, message = "User Role must be between 3 and 20 characters")
	private String userRole;

	@NotNull
	@Column(name = "user_blood_group")
	@Size(min = 1, max = 5, message = "User Blood group must be between 1 and 5 characters")
	private String userBloodGroup;

	@NotNull
	@JsonProperty
	private boolean isActive;

	@NotNull
	private int failedLoginCounts;

	public Users() {
		super();
	}

	public Users(@NotNull @Size(min = 3, max = 50, message = "User name must be between 3 and 50 characters") String userName,
			@NotNull String userEmail,
			@NotNull @Size(min = 3, max = 50, message = "User name must be between 3 and 50 characters") String userPassword,
			@NotNull @Size(min = 10, max = 10, message = "User userPhone number must be 10 digits") @Pattern(regexp = "(^$|[0-9]{10})") String userPhone,
			@NotNull @Size(min = 3, max = 100, message = "User userAddress must be between 3 and 100 characters") String userAddress,
			@NotNull @Size(min = 3, max = 20, message = "User userRole must be between 3 and 20 characters") String userRole,
			@NotNull @Size(min = 1, max = 5, message = "User userBloodGroup must be between 1 and 5 characters") String userBloodGroup,
			@NotNull boolean isActive, @NotNull int failedLoginCounts) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userRole = userRole;
		this.userBloodGroup = userBloodGroup;
		this.isActive = isActive;
		this.failedLoginCounts = failedLoginCounts;
	}

	public Users(@NotNull int userId,
			@NotNull @Size(min = 3, max = 50, message = "User name must be between 3 and 50 characters") String userName,
			@NotNull @Size(min = 5, max = 50, message = "Enter valid email address") String userEmail,
			@NotNull @Size(min = 3, max = 50, message = "User name must be between 3 and 50 characters") String userPassword,
			@NotNull @Size(min = 10, max = 10, message = "User Phone number must be 10 digits") @Pattern(regexp = "(^$|[0-9]{10})") String userPhone,
			@NotNull @Size(min = 3, max = 100, message = "User Address must be between 3 and 100 characters") String userAddress,
			@NotNull @Size(min = 3, max = 20, message = "User Role must be between 3 and 20 characters") String userRole,
			@NotNull @Size(min = 1, max = 5, message = "User Blood group must be between 1 and 5 characters") String userBloodGroup,
			@NotNull boolean isActive, @NotNull int failedLoginCounts) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userRole = userRole;
		this.userBloodGroup = userBloodGroup;
		this.isActive = isActive;
		this.failedLoginCounts = failedLoginCounts;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserBloodGroup() {
		return userBloodGroup;
	}

	public void setUserBloodGroup(String userBloodGroup) {
		this.userBloodGroup = userBloodGroup;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getFailedLoginCounts() {
		return failedLoginCounts;
	}

	public void setFailedLoginCounts(int failedLoginCounts) {
		this.failedLoginCounts = failedLoginCounts;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userPhone=" + userPhone + ", userAddress=" + userAddress + ", userRole=" + userRole
				+ ", userBloodGroup=" + userBloodGroup + ", isActive=" + isActive + ", failedLoginCounts="
				+ failedLoginCounts + "]";
	}

}
