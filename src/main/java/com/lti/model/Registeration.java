package com.lti.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="REGISTERATION")
public class Registeration {

	@Id
	@GeneratedValue
	@Column(name="REGISTERATION_ID")
	private int registerationId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="FIRSTNAME")
	private String firstname;
	
	@Column(name="LASTNAME")
	private String lastname;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
//	@Column(name="CONFIRM PASSWORD")
	//private String confPassword;
	
	@Column(name="DATEOFBIRTH")
	private LocalDate dateOfBirth;
		

	@Column(name="PHONE_NUMBER")
	private String mobileNumber;
	

	/*
	public String getConfPassword() {
		return confPassword;
	}

	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}
*/
	public int getRegisterationId() {
		return registerationId;
	}

	public void setRegisterationId(int registerationId) {
		this.registerationId = registerationId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	

	@Override
	public String toString() {
		return "Registeration [registerationId=" + registerationId + ", title=" + title + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", password=" + password + ", dateOfBirth="
				+ dateOfBirth + ", mobileNumber=" + mobileNumber + "]";
	}

	
	
	
	
}
