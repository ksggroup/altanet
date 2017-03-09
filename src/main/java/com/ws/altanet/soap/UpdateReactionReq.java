package com.ws.altanet.soap;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "UpdateReactionReq")
public class UpdateReactionReq implements Serializable {
	
	@XmlElement(name = "reaction_id", required = true)
	private Long reaction_id;
	private Long type;
	
	public Long getReaction_id() {
		return reaction_id;
	}
	public void setReaction_id(Long reaction_id) {
		this.reaction_id = reaction_id;
	}
	public Long getType() {
		return type;
	}
	public void setType(Long type) {
		this.type = type;
	}
	

}
