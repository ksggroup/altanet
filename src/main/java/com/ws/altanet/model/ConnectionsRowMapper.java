package com.ws.altanet.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ConnectionsRowMapper implements RowMapper<Connections> {

	public Connections mapRow(ResultSet rs, int rowNum) throws SQLException {
		Connections connections = new Connections();
		
		connections.setConnection_id(rs.getLong(1));
		connections.setProfile_id(rs.getLong(1));
		connections.setUser_id(rs.getLong(1));
		
		return connections;
	}

}
