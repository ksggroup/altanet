package com.ws.altanet.dao;



import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ws.altanet.model.AcademicRowMapper;
import com.ws.altanet.model.Academic_record;

import com.ws.altanet.util.Constants;
@Repository
public class AcademicRecordDAOImpl implements AcademicRecordDAO {
	
	private static final Logger logger = Logger.getLogger(AcademicRecordDAO.class);
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	
	public Academic_record getAcademicRecord(Long user_id) {
		logger.info("Setting jdbctemplate.");
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
		
		logger.info("Before try.");
		try {
			return jdbcTemplate.queryForObject(Constants.ACADEMIC_SELECT, new Long [] {user_id}, new AcademicRowMapper());
		} catch (Exception e) {
			logger.info("Error :" + e.toString());	
			return null;
		} 
		
		
	}


	public int InsertAcademicRecord( String course, String year_level, Long user_id) {
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
		
		return jdbcTemplate.update(Constants.ACADEMIC_INSERT, new Object[] { course,year_level,user_id });
	}


	
}
