package com.ws.altanet.util;

public class Constants {
	public static final String USERS_SELECT = "SELECT * FROM users WHERE username = ? AND password = ? LIMIT 1;";
	public static final String ACADEMIC_SELECT = "SELECT * FROM academic_record where user_id = ? LIMIT 1;";
	public static final String CONNECTIONS_SELECT = "SELECT * FROM connections WHERE user_id = ?";
	public static final String REACTIONS_SELECT = "SELECT * FROM reaction WHERE post_id = ?";
	
	public static final String POST_SELECT = "SELECT * FROM post WHERE user_id = ?";
	public static final String POST_DELETE = "DELETE from post where post_id= ?";
	public static final String POST_INSERT = "INSERT into post(content, datetime, user_id) values (?, NOW() , ?)";
	public static final String POST_UPDATE = "UPDATE post SET content = ?, datetime = NOW() where post_id= ?";
	
	public static final String COMMENTS_SELECT = "SELECT * FROM comments WHERE post_id = ?";
	public static final String COMMENTS_DELETE = "DELETE  FROM comments WHERE comment_id = ?";
	public static final String COMMENTS_UPDATE = "UPDATE comments SET content = ?, date_time = NOW()  where comment_id= ?";
	
}
