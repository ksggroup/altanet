package com.ws.altanet.soap;

import java.io.Serializable;

public class InsertPostResponse implements Serializable {
	
	private int insertRows;

	public int getInsertRows() {
		return insertRows;
	}

	public void setInsertRows(int insertRows) {
		this.insertRows = insertRows;
	}
}
