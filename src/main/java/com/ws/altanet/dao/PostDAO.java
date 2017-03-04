package com.ws.altanet.dao;

import java.util.List;

import com.ws.altanet.model.Post;

public interface PostDAO {
	public List<Post> getPosts(Long user_id);
	public int deletePost(Long post_id);
	public int updatePost(Long postId, String content);
	public int addPost(Long user_id, String content);
}
