package com.myproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.myproject.connection.DBConn;
import com.myproject.model.Thread;

public class ThreadDAO {

	public static ArrayList<Thread> getAllThread() throws Exception {
		ArrayList<Thread> threads = new ArrayList<>();
		try (Connection con = DBConn.getConnection();) {
			String query = "SELECT * FROM threads";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Thread thread = new Thread(rs.getInt("thread_id"),
										rs.getString("thread_name"),
										rs.getString("description"),
										rs.getString("img"),
										rs.getDate("created_at"));
				thread.setLastPost(PostDAO.getLastestPostDetail(thread.getThread_id()));
				threads.add(thread);
				System.out.println(thread.toString());
			}
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//DBConn.close(con);
		return threads;
	}
	
	public static boolean addNewThread(Thread thread) {
        String sql = "INSERT INTO threads (thread_name, description, img) VALUES (?, ?, ?)";
        try (Connection con = DBConn.getConnection();) {
        	PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, thread.getThread_name());
            preparedStatement.setString(2, thread.getDescription());
            preparedStatement.setString(3, thread.getImg());
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Add new Thread");
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public static Thread getThreadByID (int id) {
		String sql = "SELECT * FROM threads WHERE thread_id = ?";
		Thread thread = null;
		try (Connection con = DBConn.getConnection();) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				thread = new Thread(rs.getInt("thread_id"),
									rs.getString("thread_name"),
									rs.getString("description"),
									rs.getString("img"),
									rs.getDate("created_at"));
				thread.setAbout_info(rs.getString("about_info"));
				thread.setLastPost(PostDAO.getLastestPostDetail(thread.getThread_id()));
				System.out.println(thread.toString());
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return thread;
	}
	
	public static boolean updateThread(Thread thread) {
		String sql = "UPDATE threads SET thread_name = ?, description = ?, img = ? WHERE thread_id = ?";
        try (Connection con = DBConn.getConnection();) {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, thread.getThread_name());
            ps.setString(2, thread.getDescription());
            ps.setString(3, thread.getImg());
            ps.setInt(4, thread.getThread_id());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception properly in a real application
            return false;
        }
	}
	
	public static boolean deleteThread(int id) {
		String sql = "DELETE FROM threads where thread_id = ?";
		try (Connection con = DBConn.getConnection();) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int rowAffected = ps.executeUpdate();
			System.out.println("Delete a Thread");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
