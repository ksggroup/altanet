package com.ws.altanet.soap;

import java.io.Serializable;
import java.util.List;

import com.ws.altanet.model.Post;

public class GetFeedsResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Post> post;
	public List<Post> getPost() {
		return post;
	}
	public void setPost(List<Post> post) {
		this.post = post;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


}
