package com.ws.altanet.dao;

import java.util.List;

import com.ws.altanet.model.Connections;


public interface ConnectionDAO {
	public List<Connections> getConnections(Long user_id);
	public int addConnections(long profile_id, long user_id);
	public int removeConnections(long profile_id);
	
}
