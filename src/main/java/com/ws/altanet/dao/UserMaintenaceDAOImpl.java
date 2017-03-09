package com.ws.altanet.dao;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ws.altanet.util.Constants;

@Repository
public class UserMaintenaceDAOImpl implements UserMaintenaceDAO {
	private static final Logger logger = Logger.getLogger(PostDAO.class);
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public int addUser(String first_name, String middle_name, String last_name, String dob, String username,
			String password) {
		
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
		
		return jdbcTemplate.update(Constants.USER_INSERT,  new Object[] {first_name, middle_name, last_name, dob, username, password});
	
		
	}

}
