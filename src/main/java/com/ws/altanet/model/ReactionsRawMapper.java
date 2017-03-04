package com.ws.altanet.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ReactionsRawMapper implements RowMapper<Reaction> {
	

	public Reaction mapRow(ResultSet rs, int rwNumber) throws SQLException {
		Reaction reaction = new Reaction();
		reaction.setReaction_id(rs.getLong(1));
		reaction.setDate_time(rs.getTimestamp(2).toString());
		reaction.setPost_id(rs.getLong(3));
		reaction.setUser_id(rs.getLong(4));
		reaction.setType(rs.getInt(5));
		
		
		return reaction;
		
	}
}
