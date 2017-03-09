package com.ws.altanet.dao;


import com.ws.altanet.model.Academic_record;

public interface AcademicRecordDAO {
	
	public Academic_record getAcademicRecord(Long user_id);
	public int InsertAcademicRecord( String course, String year_level, Long user_id);

}
