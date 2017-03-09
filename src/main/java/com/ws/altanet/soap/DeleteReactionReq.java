package com.ws.altanet.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DeleteReactionRequest")
public class DeleteReactionReq {
	@XmlElement(name = "reaction_id", required = true)
	private Long reaction_id;

	public Long getReaction_id() {
		return reaction_id;
	}

	public void setReaction_id(Long reaction_id) {
		this.reaction_id = reaction_id;
	}

	
}
