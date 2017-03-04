package com.ws.altanet.soap;

import java.io.Serializable;
import java.util.List;

import com.ws.altanet.model.Connections;


public class ConnectionsResponse implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private List<Connections> connections;
	public List<Connections> getConnections(){
		return connections;
		
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setConnections(List<Connections> connections) {
		this.connections = connections;
	}
	
}
