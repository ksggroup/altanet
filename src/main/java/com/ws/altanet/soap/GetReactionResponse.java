package com.ws.altanet.soap;

import java.io.Serializable;
import java.util.List;

import com.ws.altanet.model.Post;
import com.ws.altanet.model.Reaction;

public class GetReactionResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Reaction> reaction;
	
	public List<Reaction> getReaction() {
		return reaction;
	}
	
	
	public void setReaction(List<Reaction> reaction) {
		this.reaction =  reaction;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
