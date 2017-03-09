package com.ws.altanet.soap;

import java.io.Serializable;

public class DeleteConnectionsRes implements  Serializable{
	private int deleteRows;

	public int getDeleteRows() {
		return deleteRows;
	}

	public void setDeleteRows(int deleteRows) {
		this.deleteRows = deleteRows;
	}

}
