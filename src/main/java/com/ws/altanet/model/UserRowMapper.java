package com.ws.altanet.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rwNumber) throws SQLException {
		User user = new User();

		user.setUser_id(rs.getLong(1));
		user.setFirst_name(rs.getString(2));
		user.setMiddle_name(rs.getString(3));
		user.setLast_name(rs.getString(4));
		user.setDob(rs.getDate(5));
		user.setUsername(rs.getString(6));
		user.setPassword(rs.getString(7));
		user.setProfile_pic(rs.getString(8));

		return user;
	}
}