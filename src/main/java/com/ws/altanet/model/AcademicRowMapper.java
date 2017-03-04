package com.ws.altanet.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AcademicRowMapper implements RowMapper<Academic_record> {
	public Academic_record mapRow(ResultSet rs, int rwNumber) throws SQLException {
		
		Academic_record academic_record = new Academic_record();
		
		
		academic_record.setAcademics_id(rs.getLong(1));
		academic_record.setCourse(rs.getString(2));
		academic_record.setYear_level(rs.getString(3));
		academic_record.setUser_id(rs.getLong(4));

		return academic_record;
	}
	
	}

