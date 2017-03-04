package com.ws.altanet.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CommentsRowMapper implements RowMapper<Comments> {

	public Comments mapRow(ResultSet rs, int rwNumber) throws SQLException {
		Comments comment = new Comments();
	
		comment.setComment_id(rs.getLong(1));
		comment.setContent(rs.getString(2));
		comment.setDate_time(rs.getTimestamp(3).toString());
		comment.setPost_id(rs.getLong(4));
		comment.setUser_id(rs.getLong(5));
		
		return comment;
	}

}
