package com.ws.altanet.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.enterprise.inject.New;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sun.xml.wss.saml.internal.saml11.jaxb10.Object;
import com.ws.altanet.model.User;
import com.ws.altanet.model.UserRowMapper;
import com.ws.altanet.service.AltaEndpointService;
import com.ws.altanet.util.Constants;

@Repository
public class AuthenticationDAOImpl implements AuthenticationDAO {

	private static final Logger logger = Logger.getLogger(AuthenticationDAO.class);
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public User getAuthenticatedUser(String username, String password) {

		logger.info("Setting jdbctemplate.");
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);

		logger.info("Before try.");
		try {
			return jdbcTemplate.queryForObject(Constants.USERS_SELECT, new String[] { username, password },
					new UserRowMapper());
		} catch (Exception e) {
			logger.info("Error :" + e.toString());
			return null;
		}

	}

	

}
