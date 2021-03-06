package com.ws.altanet.soap;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "InsertReactionRequest")
public class InsertReactionReq implements Serializable{
	
	@XmlElement(name = "post_id", required = true)
	private Long post_id;
	public Long getPost_id() {
		return post_id;
	}
	public void setPost_id(Long post_id) {
		this.post_id = post_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getType() {
		return type;
	}
	public void setType(Long type) {
		this.type = type;
	}
	private Long user_id;
	private Long type;
	
	
}
