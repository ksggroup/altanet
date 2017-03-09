package com.ws.altanet.dao;
import java.util.List;

import com.ws.altanet.model.Post;
import com.ws.altanet.model.Reaction;

public interface ReactionsDAO {
	public List<Reaction> getReaction(Long post_id);
	public int deleteReaction(Long reaction_id);
	public int updateReaction(Long reaction_id, Long type);
	public int addReaction(Long post_id, Long user_id, Long type);
	
}
