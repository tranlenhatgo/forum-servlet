package com.myproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.myproject.connection.DBConn;
import com.myproject.model.User;

public class UserDAO {
	
	public static User userLogin(String email,String password) {
		User user = null;
		try(Connection con = DBConn.getConnection()) {
			String query = "SELECT * FROM users WHERE email = ? AND password = ?;";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			System.out.println("User Login "+email+" "+password);
			if (rs.next()) {
				user = new User(rs.getInt("user_id"), rs.getString("username"), email, password,rs.getString("profile_pic"),rs.getInt("admin"),null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public static User findUserById(int id) {
		User user = null;
		try (Connection con = DBConn.getConnection()) {
			String query = "SELECT * FROM users WHERE user_id = ?;";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("user_id"), 
								rs.getString("username"), 
								rs.getString("email"), 
								rs.getString("password"),
								rs.getString("profile_pic"),
								rs.getInt("admin"),
								rs.getDate("created_at"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public static User findUserByPost(int id) {
		User user = null;
		try (Connection con = DBConn.getConnection()) {
			String query = "SELECT * FROM users WHERE user_id = ?;";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("user_id"), 
								rs.getString("username"), 
								rs.getString("email"), 
								rs.getString("password"),
								rs.getString("profile_pic"),
								rs.getInt("admin"),
								rs.getDate("created_at"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
