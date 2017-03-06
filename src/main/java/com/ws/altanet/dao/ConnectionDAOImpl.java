package com.ws.altanet.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ws.altanet.model.Connections;
import com.ws.altanet.model.Post;
import com.ws.altanet.util.Constants;
@Repository
public class ConnectionDAOImpl implements ConnectionDAO {
	private static final Logger logger = Logger.getLogger(PostDAO.class);
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public List<Connections> getConnections(Long user_id) {
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);		
		List<Connections> connections = new ArrayList<Connections>();
		
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(Constants.CONNECTIONS_SELECT,  new Object[] {user_id});
			
			if ((rows != null) && (rows.size() > 0)) {

			    for (Map<String, Object> tempRow : rows) {
			        Connections connection = new Connections();
			        connection.setConnection_id((Long) tempRow.get("connection_id"));
			        connection.setProfile_id((Long) tempRow.get("profile_id"));
			        connection.setUser_id((Long) tempRow.get("user_id"));
			        connections.add(connection);
			    }
			}
			
		} catch (Exception e) {
			logger.error(e);
		}
		return connections;
	}

	public int addConnections(long profile_id, long user_id) {
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
		
		return jdbcTemplate.update(Constants.CONNECTIONS_INSERT, new Object[] {profile_id, user_id});
	}

	

	public int removeConnections(long profile_id) {
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
		
		return jdbcTemplate.update(Constants.CONNECTIONS_DELETE, new Object[] {profile_id});
	}

}
