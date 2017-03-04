package com.ws.altanet.soap;

import java.io.Serializable;

import com.ws.altanet.model.Academic_record;

public class AcademicRecordResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Academic_record academicRecord;

	public Academic_record getAcademicRecord() {
		return academicRecord;
	}

	public void setAcademicRecord(Academic_record academicRecord) {
		this.academicRecord = academicRecord;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
