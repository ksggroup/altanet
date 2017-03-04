package com.ws.altanet.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PostRowMapper implements RowMapper<Post> {

	public Post mapRow(ResultSet rs, int rwNumber) throws SQLException {
		Post post = new Post();
			
		post.setPost_id(rs.getLong(1));
		post.setContent(rs.getString(2));
		post.setDatetime(rs.getTimestamp(3).toString());
		post.setUser_id(rs.getLong(4));
		
		return post;
	}
}

