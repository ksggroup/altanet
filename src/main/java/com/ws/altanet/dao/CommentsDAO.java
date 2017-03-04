package com.ws.altanet.dao;

import java.util.List;
import com.ws.altanet.model.Comments;

public interface CommentsDAO {
	public List<Comments> getComments(Long post_id);
	public int deleteComment(Long comment_id);
	public int updateComment( String content, Long comment_id );
	public int addComment(Long post_id, String content, Long user_id);

}
