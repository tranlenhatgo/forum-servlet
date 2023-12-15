package com.myproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.myproject.connection.DBConn;
import com.myproject.model.Post;
import com.myproject.model.Thread;
import com.myproject.model.User;

public class PostDAO {
	
	public static ArrayList<Post> getAllPostByThread(int thread_id) throws Exception {
		ArrayList<Post> posts = new ArrayList<>();
		try (Connection con = DBConn.getConnection();) {
			String query = "SELECT * FROM posts WHERE thread_id = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, thread_id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				User creater = UserDAO.findUserByPost(rs.getInt("user_id"));
				Thread thread = ThreadDAO.getThreadByID(thread_id);
				Post post = new Post(rs.getInt("post_id"),
										creater,
										thread,
										rs.getString("title"),
										rs.getString("content"),
										rs.getString("img"),
										rs.getDate("created_at"));
				posts.add(post);
			}
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return posts;
	}
	
	public static ArrayList<Post> getAllPost() throws Exception {
		ArrayList<Post> posts = new ArrayList<>();
		try (Connection con = DBConn.getConnection();) {
			String query = "SELECT * FROM posts";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				User creater = UserDAO.findUserByPost(rs.getInt("user_id"));
				Thread thread = ThreadDAO.getThreadByID(rs.getInt("thread_id"));
				Post post = new Post(rs.getInt("post_id"),
										creater,
										thread,
										rs.getString("title"),
										rs.getString("content"),
										rs.getString("img"),
										rs.getDate("created_at"));
				posts.add(post);
			}
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return posts;
	}
	
	public static String getLastestPostDetail(int thread_id) throws Exception {
		String details = null;
		Connection con = DBConn.getConnection();
		try {
			String query = "SELECT p.created_at, u.username "
					+ "FROM posts p "
					+ "JOIN users u ON p.user_id = u.user_id "
					+ "WHERE p.thread_id = ? "
					+ "ORDER BY p.created_at DESC "
					+ "LIMIT 1;";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, thread_id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				details = "by "+rs.getDate("created_at")+" at "+rs.getString("username");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return details;
	}
	
	public static void createNewPost(Post post) throws Exception {
		try (Connection con = DBConn.getConnection()) {
			String query = "SELECT p.created_at, u.username "
					+ "FROM posts p "
					+ "JOIN users u ON p.user_id = u.user_id "
					+ "WHERE p.thread_id = ? "
					+ "ORDER BY p.created_at DESC "
					+ "LIMIT 1;";
			PreparedStatement pst = con.prepareStatement(query);
			//pst.setInt(1, thread_id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				//details = "by "+rs.getDate("created_at")+" at "+rs.getString("username");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
