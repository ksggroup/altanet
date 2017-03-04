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
import com.ws.altanet.model.Post;
import com.ws.altanet.model.Reaction;
import com.ws.altanet.util.Constants;

@Repository
public class ReactionsDAOimpl implements ReactionsDAO {
	private static final Logger logger = Logger.getLogger(ReactionsDAO.class);
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public List<Reaction> getReaction(Long post_id) {
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);		
		List<Reaction> reaction = new ArrayList<Reaction>();
		
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(Constants.REACTIONS_SELECT,  new Object[] {post_id});
			
			if ((rows != null) && (rows.size() > 0)) {

			    for (Map<String, Object> tempRow : rows) {
			        Reaction reactions = new Reaction();
			        reactions.setReaction_id((Long) tempRow.get("reaction_id"));
			        reactions.setDate_time((String) tempRow.get("datetime").toString());
			        reactions.setPost_id((Long) tempRow.get("post_id"));
			        reactions.setUser_id((Long) tempRow.get("user_id"));
			        reactions.setType(((Integer)tempRow.get("type")).intValue());
			        
			        
			        reaction.add(reactions);
			    }
			}
			
		} catch (Exception e) {
			logger.error(e);
		}
		return reaction;
	
	}
		
	

	public int deleteReaction(Long post_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateReaction(Post post) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int addReaction(Long user_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
