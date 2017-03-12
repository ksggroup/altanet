package com.ws.altanet.soap;

import java.io.Serializable;
import java.util.List;

import com.ws.altanet.model.Post;
import com.ws.altanet.model.User;

public class SearchUserRes implements Serializable{
	private List<User> user;
	

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}
	

}
