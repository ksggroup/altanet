package com.ws.altanet.model;

public class Reaction {
	long reaction_id;
	String date_time;
	long post_id;
	long user_id;
	int type; 
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public long getReaction_id() {
		return reaction_id;
	}
	public void setReaction_id(long reaction_id) {
		this.reaction_id = reaction_id;
	}
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	public long getPost_id() {
		return post_id;
	}
	public void setPost_id(long post_id) {
		this.post_id = post_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	
}
