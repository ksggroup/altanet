package com.ws.altanet.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ws.altanet.model.Post;
import com.ws.altanet.model.PostRowMapper;
import com.ws.altanet.util.Constants;

@Repository
public class PostDAOImpl implements PostDAO {
	private static final Logger logger = Logger.getLogger(PostDAO.class);
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	
	
	public List<Post> getPosts(Long user_id) {
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);		
		List<Post> posts = new ArrayList<Post>();
		
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(Constants.POST_SELECT,  new Object[] {user_id});
			
			if ((rows != null) && (rows.size() > 0)) {

			    for (Map<String, Object> tempRow : rows) {
			        Post post = new Post();
			        post.setContent((String) tempRow.get("content"));
			        post.setDatetime((String) tempRow.get("datetime").toString());
			        post.setPost_id((Long) tempRow.get("post_id"));
			        post.setUser_id((Long) tempRow.get("user_id"));
			        
			        posts.add(post);
			    }
			}
			
		} catch (Exception e) {
			logger.error(e);
		}

		return posts;
	}

	public int deletePost(Long post_id) {
		
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
			
		return jdbcTemplate.update(Constants.POST_DELETE, new Object[] {post_id});
		
	}

	public int updatePost(Long postId, String content) {
		
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
		
		return jdbcTemplate.update(Constants.POST_UPDATE, new Object[] {content, postId});
		
	}

	public int addPost(Long user_id, String content) {
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
		
		return jdbcTemplate.update(Constants.POST_INSERT, new Object[] {content, user_id});
	}

	public List<Post> getFeeds(Long user_id) {
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);		
		List<Post> posts = new ArrayList<Post>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(Constants.FEEDS_JOIN,  new Object[] {user_id, user_id});
			
			if ((rows != null) && (rows.size() > 0)) {

			    for (Map<String, Object> tempRow : rows) {
			        Post post = new Post();
			        
			        post.setUser_id((Long) tempRow.get("user_id"));
			         post.setFirst_name((String) tempRow.get("first_name"));
			        post.setMiddle_name((String) tempRow.get("middle_name"));
			        post.setLast_name((String) tempRow.get("last_name"));
			        post.setPost_id((Long) tempRow.get("post_id"));
			        post.setContent((String) tempRow.get("content"));
			        post.setDatetime((String) tempRow.get("datetime").toString());
       
			        posts.add(post);
			    }
			}
			
		} catch (Exception e) {
			logger.error(e);
		}

		return posts;
	
		
		
		
		
	}

}
