package com.myproject.user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.dao.PostDAO;
import com.myproject.dao.ThreadDAO;
import com.myproject.dao.UserDAO;
import com.myproject.model.Post;
import com.myproject.model.Thread;
import com.myproject.model.User;


public class CreateNewPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			String content = (String) request.getParameter("content");
			String img = (String) request.getParameter("img");
			User user_id = UserDAO.findUserById( Integer.valueOf(request.getParameter("user_id")));
			Thread thread = ThreadDAO.getThreadByID( Integer.valueOf(request.getParameter("thread_id")));
			Post post = new Post(user_id, thread, content, img);
			//PostDAO.
			RequestDispatcher dispatcher = request.getRequestDispatcher("/thread");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
