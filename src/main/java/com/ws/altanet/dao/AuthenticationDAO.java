package com.ws.altanet.dao;

import javax.sql.DataSource;

import com.ws.altanet.model.User;

public interface AuthenticationDAO {
	
	public void setDataSource(DataSource dataSource);

	public User getAuthenticatedUser(String username, String password);
	
}
