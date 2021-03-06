package com.ws.altanet.soap;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ConnectionsRequest")
public class ConnectionsRequest implements Serializable  {


private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "user_id", required = true)
	private Long user_id;
	
	
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	
}
