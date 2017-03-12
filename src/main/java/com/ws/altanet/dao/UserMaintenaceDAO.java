package com.ws.altanet.dao;

import java.util.List;

import com.ws.altanet.model.Post;
import com.ws.altanet.model.User;

public interface UserMaintenaceDAO {
	
	public int addUser(String first_name, String middle_name, String last_name, String dob, String username, String password);
	public List<User>searchUser(String name);
	

}
