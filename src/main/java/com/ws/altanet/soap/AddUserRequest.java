package com.ws.altanet.soap;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "addUserRequest")
public class AddUserRequest implements Serializable{
	
	@XmlElement(name = "first_name", required = true)
	private String first_name;
	@XmlElement(name = "middle_name", required = true)
	private String middle_name;
	@XmlElement(name = "last_name", required = true)
	private String last_name;
	@XmlElement(name = "dob", required = true)
	private String dob;
	@XmlElement(name = "username", required = true)
	private String username;
	@XmlElement(name = "password", required = true)
	private String password;
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
	

}
