package com.myproject.user.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.connection.DBConn;
import com.myproject.dao.ThreadDAO;
import com.myproject.model.Thread;

public class HomeUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			ArrayList<Thread> threads = ThreadDAO.getAllThread();
			request.setAttribute("threads", threads);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home-path");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
