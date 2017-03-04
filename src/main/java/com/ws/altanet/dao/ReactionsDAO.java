package com.ws.altanet.dao;
import java.util.List;

import com.ws.altanet.model.Post;
import com.ws.altanet.model.Reaction;

public interface ReactionsDAO {
	public List<Reaction> getReaction(Long post_id);
	public int deleteReaction(Long post_id);
	public int updateReaction(Post post);
	public int addReaction(Long user_id);
	
}
