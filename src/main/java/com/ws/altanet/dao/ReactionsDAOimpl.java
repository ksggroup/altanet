package com.ws.altanet.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
		
	

	public int deleteReaction(Long reaction_id) {
		
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
		
		return jdbcTemplate.update(Constants.REACTIONS_DELETE, new Object[] {reaction_id});
	}

	public int updateReaction( Long type, Long reaction_id) {
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
		
		return jdbcTemplate.update(Constants.REACTIONS_UPDATE, new Object[] {type, reaction_id });
		
	}

	public int addReaction(Long post_id, Long user_id, Long type) {
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
		
		return jdbcTemplate.update(Constants.REACTIONS_INSERT, new Object[] { post_id,  user_id, type});
	}

}
