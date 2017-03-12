package com.ws.altanet.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ws.altanet.model.Post;
import com.ws.altanet.model.User;
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

	public  List <User> searchUser(String name) {
		
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);		
		List<User> user = new ArrayList<User>();
		
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(Constants.USER_SEARCH,  new Object[] {name});
			
			if ((rows != null) && (rows.size() > 0)) {

			    for (Map<String, Object> tempRow : rows) {
			        User users = new User();
			        users.setUser_id((Long) tempRow.get("user_id"));
			        users.setFirst_name((String) tempRow.get("first_name"));
			        users.setMiddle_name((String) tempRow.get("middle_name"));
			        users.setLast_name((String) tempRow.get("last_name"));        
			        user.add(users);
			    }
			}
			
		} catch (Exception e) {
			logger.error(e);
		}
		return user;
	}
	
}
