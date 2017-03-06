package com.ws.altanet.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ws.altanet.model.Comments;
import com.ws.altanet.util.Constants;

@Repository
public class CommentsDAOImpl implements CommentsDAO {
	private static final Logger logger = Logger.getLogger(PostDAO.class);
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public List<Comments> getComments(Long post_id) {
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);		
		List<Comments> comments = new ArrayList<Comments>();
		
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(Constants.COMMENTS_SELECT,  new Object[] {post_id});
			
			if ((rows != null) && (rows.size() > 0)) {

			    for (Map<String, Object> tempRow : rows) {
			        Comments comment = new Comments();
			        comment.setContent((String) tempRow.get("content"));
			        comment.setDate_time((String) tempRow.get("date_time").toString());
			        comment.setPost_id((Long) tempRow.get("post_id"));
			        comment.setUser_id((Long) tempRow.get("user_id"));
			        comment.setUser_id((Long) tempRow.get("comment_id"));
			        
			        comments.add(comment);
			    }
			}
			
		} catch (Exception e) {
			logger.error(e);
		}
		return comments;
	
	}

	public int deleteComment(Long comment_id) {
		
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
		
		return jdbcTemplate.update(Constants.COMMENTS_DELETE, new Object[] {comment_id});
	}

	public int updateComment( String content , Long comment_id ) {
		
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
		
		return jdbcTemplate.update(Constants.COMMENTS_UPDATE, new Object[] { content, comment_id});
		
	}

	public int addComment(Long post_id, String content, Long user_id) {
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
		
		return jdbcTemplate.update(Constants.COMMENTS_INSERT, new Object[] {content,post_id, user_id});
		
	}
}
