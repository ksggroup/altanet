package com.ws.altanet.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebParam;
import javax.jws.WebResult;

import com.sun.xml.ws.security.opt.api.tokens.Timestamp;
import com.ws.altanet.dao.AcademicRecordDAO;
import com.ws.altanet.dao.AuthenticationDAO;
import com.ws.altanet.dao.CommentsDAO;
import com.ws.altanet.dao.ConnectionDAO;
import com.ws.altanet.dao.PostDAO;
import com.ws.altanet.dao.ReactionsDAO;
import com.ws.altanet.dao.UserMaintenaceDAO;
import com.ws.altanet.model.Academic_record;
import com.ws.altanet.model.Comments;
import com.ws.altanet.model.Connections;
import com.ws.altanet.model.Post;
import com.ws.altanet.model.Reaction;
import com.ws.altanet.model.User;
import com.ws.altanet.soap.AcademicRecordRequest;
import com.ws.altanet.soap.AcademicRecordResponse;
import com.ws.altanet.soap.AddUserRequest;
import com.ws.altanet.soap.AddUserResponse;
import com.ws.altanet.soap.AuthenticateRequest;
import com.ws.altanet.soap.AuthenticateResponse;
import com.ws.altanet.soap.CommentResponse;
import com.ws.altanet.soap.ConnectionsRequest;
import com.ws.altanet.soap.ConnectionsResponse;
import com.ws.altanet.soap.DeleteCommentsRequest;
import com.ws.altanet.soap.DeleteCommentsResponse;
import com.ws.altanet.soap.DeleteConnectionsReq;
import com.ws.altanet.soap.DeleteConnectionsRes;
import com.ws.altanet.soap.DeletePostRequest;
import com.ws.altanet.soap.DeletePostResponse;
import com.ws.altanet.soap.DeleteReactionReq;
import com.ws.altanet.soap.DeleteReactionRes;
import com.ws.altanet.soap.GetCommentsRequest;
import com.ws.altanet.soap.GetFeedsReq;
import com.ws.altanet.soap.GetFeedsRes;
import com.ws.altanet.soap.GetPostRequest;
import com.ws.altanet.soap.GetPostResponse;
import com.ws.altanet.soap.GetReactionRequest;
import com.ws.altanet.soap.GetReactionResponse;
import com.ws.altanet.soap.InsertAcademicReq;
import com.ws.altanet.soap.InsertAcademicRes;
import com.ws.altanet.soap.InsertCommentsReq;
import com.ws.altanet.soap.InsertCommentsRes;
import com.ws.altanet.soap.InsertConnectionsReq;
import com.ws.altanet.soap.InsertConnectionsRes;
import com.ws.altanet.soap.InsertPostRequest;
import com.ws.altanet.soap.InsertPostResponse;
import com.ws.altanet.soap.InsertReactionReq;
import com.ws.altanet.soap.InsertReactionRes;
import com.ws.altanet.soap.UpdateCommentsRequest;
import com.ws.altanet.soap.UpdateCommentsResponse;
import com.ws.altanet.soap.UpdatePostRequest;
import com.ws.altanet.soap.UpdatePostResponse;
import com.ws.altanet.soap.UpdateReactionReq;
import com.ws.altanet.soap.UpdateReactionRes;

/* Altanet Master */
/* This is the entry point class of the entire ws */

@WebService /* http://localhost:8080/altanet/service */
public class AltaEndpointService {
	@Autowired
	AuthenticationDAO authDao;

	@Autowired
	AcademicRecordDAO academicRecordDao;
	
	@Autowired
	PostDAO postDao;
	
	@Autowired
	CommentsDAO commentDao;
 
	@Autowired
	ConnectionDAO connectionDao;
	
	@Autowired
	ReactionsDAO reactionsDAO; 
	
	@Autowired
	UserMaintenaceDAO userDao;
	
	private static final Logger logger = Logger.getLogger(AltaEndpointService.class);
	
	/* http://localhost:8080/altanet/service?method=auth */
	@WebMethod(operationName = "auth")
	public @WebResult(name = "AuthenticateResponse", partName = "AuthenticateResponse") AuthenticateResponse auth(
			@WebParam(name = "AuthenticateRequest", partName = "AuthenticateRequest") AuthenticateRequest request) {

		logger.info("Starting service.");
		AuthenticateResponse response = new AuthenticateResponse();

		logger.info("Calling authDao.getAuthenticatedUser."); 
		
		// Calls JDBC library to access data from the database. 
		User user = authDao.getAuthenticatedUser(request.getUsername(), request.getPassword());
		
		logger.info("Evaluating user object.");
		
		// if user is null then no record is found, hence username/password is incorrect.
		if (user != null) {
			logger.debug("Username: " + user.getUsername());
			logger.debug("Password: " + user.getPassword());
			
			response.setUser(user); // Put user object from database in response.user object
			response.setReturn_code(0);
			response.setReturn_description("Successful login");
		} else {
			response.setReturn_code(-1);
			response.setReturn_description("Login failed");
		}

		// Return response object, instance of AuthenticateResponse
		return response;

	}
	//note
	@WebMethod(operationName = "insertUser")
	public @WebResult(name = "InsertUserResponse", partName = "InsertUserResponse")AddUserResponse insertUser(
			@WebParam(name = "InsertUserRequest", partName = "InsertUserRequest") AddUserRequest request) {
		logger.info("Starting service.");
		AddUserResponse response = new AddUserResponse();
		
		int insertCount = userDao.addUser(request.getFirst_name(), request.getMiddle_name(), request.getLast_name(), request.getDob(), request.getUsername(), request.getPassword());
		
		logger.info("Evaluating user object...");
		response.setInsertRows(insertCount);
		
		logger.info("Returning response: " + insertCount);
		
		return response;
	}

	/* http://localhost:8080/altanet/service?method=getAcademicRecord */
	@WebMethod(operationName = "getAcademicRecord")
	public @WebResult(name = "AcademicRecordResponse", partName = "AcademicRecordResponse") AcademicRecordResponse getAcademicRecord(
			@WebParam(name = "AcademicRecordRequest", partName = "AcademicRecordRequest") AcademicRecordRequest request) {

		logger.info("Starting service.");
		AcademicRecordResponse response = new AcademicRecordResponse();

		logger.info("Calling AcademidicRecordDao");
		Academic_record acads = academicRecordDao.getAcademicRecord(request.getUser_id());

		logger.info("Evaluating user object.");
		if (acads != null) {
			logger.debug("Academic Id: " + acads.getAcademics_id());
			logger.debug("User Id: " + acads.getUser_id());
			logger.debug("Course: " + acads.getCourse());
			logger.debug("Year Level: " + acads.getYear_level());

			response.setAcademicRecord(new Academic_record());

			response.getAcademicRecord().setAcademics_id(acads.getAcademics_id());
			response.getAcademicRecord().setUser_id(acads.getUser_id());
			response.getAcademicRecord().setCourse(acads.getCourse());
			response.getAcademicRecord().setYear_level(acads.getYear_level());

		} else {
			response.setAcademicRecord(new Academic_record());
		}

		return response;
	}
	@WebMethod(operationName = "insertAcademicRecord")
	public @WebResult(name = "InsertAcademicRes", partName = "InsertAcademicRes")InsertAcademicRes insertAcads(
			@WebParam(name = "InsertAcademicReq", partName = "InsertAcademicReq") InsertAcademicReq request) {
		logger.info("Starting service.");
		InsertAcademicRes response = new InsertAcademicRes();
		
		int insertCount = academicRecordDao.InsertAcademicRecord(request.getCourse(), request.getCourse(), request.getUser_id());
		
		logger.info("Evaluating user object...");
		response.setInsertRows(insertCount);
		
		logger.info("Returning response: " + insertCount);
		
		return response;
	}
	
	/* http://localhost:8080/altanet/service?method=getAcademicRecord */
	@WebMethod(operationName = "getPosts")
	public @WebResult(name = "GetPostResponse", partName = "GetPostResponse") GetPostResponse getPosts(
			@WebParam(name = "GetPostRequest", partName = "GetPostRequest") GetPostRequest request) {

		logger.info("Starting service.");
		GetPostResponse response = new GetPostResponse();

		logger.info("Calling postDao");
		List<Post> post = postDao.getPosts(request.getUser_id());

		logger.info("Evaluating user object." + post.size());
		if (post.size() > 0) {
			response.setPost(post);
		} 
		logger.info("Returning response.");
		return response;
	}
	
	
	@WebMethod(operationName = "getFeeds")
	public @WebResult(name = "GetFeedsResponse", partName = "GetFeedsResponse") GetFeedsRes getFeeds(
			@WebParam(name = "GetFeedsRequest", partName = "GetFeedsRequest") GetFeedsReq request) {

		logger.info("Starting service.");
		GetFeedsRes response = new GetFeedsRes();

		logger.info("Calling postDao");
		List<Post> post = postDao.getFeeds(request.getUser_id());

		logger.info("Evaluating user object." + post.size());
		if (post.size() > 0) {
			response.setPost(post);
		} 
		logger.info("Returning response.");
		return response;
	}
	@WebMethod(operationName = "deletePosts")
	public @WebResult(name = "DeletePostResponse", partName = "DeletePostResponse") DeletePostResponse deletePosts(
			@WebParam(name = "DeletePostRequest", partName = "DeletePostRequest") DeletePostRequest request) {
		
		logger.info("Starting service.");
		DeletePostResponse response = new DeletePostResponse();
		int post = postDao.deletePost(request.post_id());
		
		logger.info("Evaluating user object." + post);
		
		if (post > 0) {
			response.setDeleteRows(post);
		} 
		logger.info("Returning response.");
		return response;
	}
	
	@WebMethod(operationName = "updatePosts")
	public @WebResult(name = "UpdatePostResponse", partName = "UpdatePostResponse") UpdatePostResponse updatePosts(
			@WebParam(name = "UpdatePostRequest", partName = "UpdatePostRequest") UpdatePostRequest request) {
		logger.info("Starting service.");
		UpdatePostResponse response = new UpdatePostResponse();
		int updateCount = postDao.updatePost(request.getPost_id(), request.getContent());
		
		logger.info("Evaluating user object...");
		response.setUpdateRows(updateCount);

		logger.info("Returning response: " + updateCount);
		return response;
		
	}
	
	@WebMethod(operationName = "insertPosts")
	public @WebResult(name = "InsertPostResponse", partName = "InsertPostResponse")InsertPostResponse insertPosts(
			@WebParam(name = "InsertPostRequest", partName = "InsertPostRequest") InsertPostRequest request) {
		logger.info("Starting service.");
		InsertPostResponse response = new InsertPostResponse();
		
		int insertCount = postDao.addPost(request.getUser_id(), request.getContent());
		
		logger.info("Evaluating user object...");
		response.setInsertRows(insertCount);
		
		logger.info("Returning response: " + insertCount);
		return response;
	
	}
	@WebMethod(operationName = "getComments")
	public @WebResult(name = "CommentResponse", partName = "CommentResponse") CommentResponse getComments(
			@WebParam(name = "GetCommentsRequest", partName = "GetCommentsRequest") GetCommentsRequest request) {

		logger.info("Starting service.");
		CommentResponse response = new CommentResponse();

		logger.info("Calling CommentsDao");
		List<Comments> comment = commentDao.getComments(request.getPost_id());

		logger.info("Evaluating user object." + comment.size());
		if (comment.size() > 0) {
			response.setComments(comment);
		} 
		logger.info("Returning response.");
		return response;
	}
	@WebMethod(operationName = "deleteComment")
	public @WebResult(name = "DeleteCommentResponse", partName = "DeleteCommentResponse") DeleteCommentsResponse deleteComment(
			@WebParam(name = "DeleteCommentRequest", partName = "DeleteCommentRequest") DeleteCommentsRequest request) {
		
		logger.info("Starting service.");
		DeleteCommentsResponse response = new DeleteCommentsResponse();
		int comment = commentDao.deleteComment(request.getComment_id());
		
		logger.info("Evaluating user object." + comment);
		
		if (comment > 0) {
			response.setDeleteRows(comment);
		} 
		logger.info("Returning response.");
		return response;
	}
	//
	@WebMethod(operationName = "updateComment")
	public @WebResult(name = "UpdateCommentResponse", partName = "UpdateCommentResponse") UpdateCommentsResponse UpdateComment(
			@WebParam(name = "UpdateCommentRequest", partName = "UpdateCommentRequest") UpdateCommentsRequest request) {
		
		logger.info("Starting service.");
		UpdateCommentsResponse response = new UpdateCommentsResponse();
	int updateCount = commentDao.updateComment( request.getContent(), request.getComment_id());
		
		
		logger.info("Evaluating user object...");
		response.setUpdateRows(updateCount);

		logger.info("Returning response: " + updateCount);
		return response;
	}
	
	@WebMethod(operationName = "insertComments")
	public @WebResult(name = "InsertCommentsRes", partName = "InsertCommentsRes") InsertCommentsRes insertComments(
			@WebParam(name = "InsertCommentsReq", partName = "InsertCommentsReq") InsertCommentsReq request) {
		
		logger.info("Starting service.");
		InsertCommentsRes response = new InsertCommentsRes();
		
		int insertCount = commentDao.addComment(request.getPost_id(), request.getContent(), request.getUser_id(), request.getFirst_name(), request.getMiddle_name(), request.getLast_name());
		
		logger.info("Evaluating user object...");
		response.setInsertRows(insertCount);
		
		logger.info("Returning response: " + insertCount);
		return response;
	
	}
		
	@WebMethod(operationName = "getConnections")
	 public @WebResult(name = "ConnectionsResponse", partName = "ConnectionsResponse") ConnectionsResponse getConnections(
			@WebParam(name = "ConnectionsRequest", partName = "ConnectionsRequest") ConnectionsRequest request) {
		logger.info("Starting service.");
		 ConnectionsResponse  response = new  ConnectionsResponse();

		logger.info("Calling ConnectionsDao");
		List<Connections> connections =  connectionDao.getConnections(request.getUser_id());

		logger.info("Evaluating user object." + connections.size());
		if (connections.size() > 0) {
			response.setConnections(connections);
		} 
		logger.info("Returning response.");
		return response;
		
	}
	@WebMethod(operationName = "deleteConnections")
	public @WebResult(name = "DeleteConnectionsResponse", partName = "DeleteConnectionsResponse") DeleteConnectionsRes deleteConnections(
			@WebParam(name = "DeleteConnectionsRequest", partName = "DeleteConnectionsRequest") DeleteConnectionsReq request) {
		
		logger.info("Starting service.");
		DeleteConnectionsRes response = new DeleteConnectionsRes();
		int connection = connectionDao.removeConnections(request.getProfile_id());
		
		logger.info("Evaluating user object." + connection);
		
		if (connection > 0) {
			response.setDeleteRows(connection);
		} 
		logger.info("Returning response.");
		return response;
	}
	
		@WebMethod(operationName = "insertConnections")
	public @WebResult(name = "InsertConnectionsResponse", partName = "InsertConnectionsResponse") InsertConnectionsRes insertConnections(
			@WebParam(name = "InsertConnectionsRequest", partName = "InsertConnectionsRequest") InsertConnectionsReq request) {
		
		logger.info("Starting service.");
		InsertConnectionsRes response = new InsertConnectionsRes();
		
		int insertCount = connectionDao.addConnections(request.getProfile_id(), request.getUser_id());
		
		logger.info("Evaluating user object...");
		response.setInsertRows(insertCount);
		
		logger.info("Returning response: " + insertCount);
		return response;
	
	}
	
		
	
	
	@WebMethod(operationName = "getReactions")
	 public @WebResult(name = "GetReactionResponse", partName = "GetReactionResponse") GetReactionResponse getReaction(
				@WebParam(name = "GetReactionRequest", partName = "GetReactionRequest") GetReactionRequest request){
		logger.info("Starting service.");
		 GetReactionResponse  response = new GetReactionResponse();

		logger.info("Calling ReactionsDAO");
		List<Reaction> reactions  =  reactionsDAO.getReaction(request.getPost_id());

		logger.info("Evaluating user object." + reactions.size());
		if (reactions.size() > 0) {
			logger.info("Setting reaction...");
			response.setReaction(reactions);
		}
		
		
		return response;
	}
	@WebMethod(operationName = "deleteReaction")
	public @WebResult(name = "DeleteReactionResponse", partName = "DeleteReactionResponse") DeleteReactionRes deleteReaction(
			@WebParam(name = "DeleteReactionRequest", partName = "DeleteReactionRequest") DeleteReactionReq request) {
		
		logger.info("Starting service.");
		DeleteReactionRes response = new DeleteReactionRes();
		int reaction = reactionsDAO.deleteReaction(request.getReaction_id());
		
		logger.info("Evaluating user object." + reaction);
		
		if (reaction > 0) {
			response.setDeleteRows(reaction);
		} 
		logger.info("Returning response.");
		return response;
	}
	
	@WebMethod(operationName = "insertReaction")
	public @WebResult(name = "InsertReactionResponse", partName = "InsertReactionResponse")InsertReactionRes insertReaction(
			@WebParam(name = "InsertReactionRequest", partName = "InsertReactionRequest") InsertReactionReq request) {
		logger.info("Starting service.");
		InsertReactionRes response = new InsertReactionRes();
		
		int insertCount = reactionsDAO.addReaction(request.getPost_id(), request.getUser_id(), request.getType());
		
		logger.info("Evaluating user object...");
		response.setInsertRows(insertCount);
		
		logger.info("Returning response: " + insertCount);
		return response;
	
	}
	@WebMethod(operationName = "updateReaction")
	public @WebResult(name = "UpdateReactionRes", partName = "UpdateReactionRes") UpdateReactionRes updateReaction(
			@WebParam(name = "UpdateReactionReq", partName = "UpdateReactionReq") UpdateReactionReq request) {
		
		logger.info("Starting service.");
		UpdateReactionRes response = new UpdateReactionRes();
		int updateCount = reactionsDAO.updateReaction( request.getType(), request.getReaction_id());
		
		
		logger.info("Evaluating user object...");
		response.setUpdateRows(updateCount);

		logger.info("Returning response: " + updateCount);
		return response;
	}


	
	
	
}

