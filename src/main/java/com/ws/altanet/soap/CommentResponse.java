package com.ws.altanet.soap;

import java.io.Serializable;
import java.util.List;

import com.ws.altanet.model.Comments;


public class CommentResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Comments> comment;
	public List<Comments> getComments() {
		return comment;
	}
	public void setComments(List<Comments> comment) {
		this.comment = comment;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
