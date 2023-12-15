package com.myproject.user.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.dao.PostDAO;
import com.myproject.dao.ThreadDAO;
import com.myproject.model.Post;
import com.myproject.model.Thread;


@WebServlet
public class ThreadPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try { 
			//get thread_id and get all post with that thread_id and forward to /thread-path
			int thread_id = Integer.valueOf((String) request.getParameter("id"));
			ArrayList<Post> posts = new ArrayList<>();
			posts = PostDAO.getAllPostByThread(thread_id);
			Thread thread = ThreadDAO.getThreadByID(thread_id);
			request.setAttribute("posts", posts);
			request.setAttribute("thread", thread);
			//response.sendRedirect("thread-path");
			RequestDispatcher dispatcher = request.getRequestDispatcher("thread-path");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
