package com.ws.altanet.soap;

import java.io.Serializable;

import com.ws.altanet.model.User;

public class AuthenticateResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private int return_code;
	private String return_description;
	private User user;
	
	public int getReturn_code() {
		return return_code;
	}
	public void setReturn_code(int return_code) {
		this.return_code = return_code;
	}
	public String getReturn_description() {
		return return_description;
	}
	public void setReturn_description(String return_description) {
		this.return_description = return_description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
