package com.myproject.admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.dao.ThreadDAO;
import com.myproject.model.Thread;


public class CreateNewThread extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			String thread_name = request.getParameter("thread-name");
			String desc = request.getParameter("description");
			String img = request.getParameter("image");
			Thread thread = new Thread(thread_name, desc, img);
			Boolean rs = ThreadDAO.addNewThread(thread);
			request.setAttribute("result", rs);
			RequestDispatcher dispatcher = request.getRequestDispatcher("create-thread");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
