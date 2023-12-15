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


public class UpdateThread extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String url = request.getServletPath();
		System.out.println(url);
		try {
			switch (url) {
			case "/admin/update-thread":
				showUpdateForm(request, response);
				break;
			case "/admin/add-update-thread":
				updateThread(request, response);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.valueOf(request.getParameter("id"));
		Thread thread = ThreadDAO.getThreadByID(id);
		request.setAttribute("thread", thread);
		RequestDispatcher dispatcher = request.getRequestDispatcher("update-form.jsp");
		dispatcher.forward(request, response);
	}
	private void updateThread(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int thread_id =Integer.valueOf(request.getParameter("thread_id"));
		String thread_name = request.getParameter("thread-name");
		String desc = request.getParameter("description");
		String img = request.getParameter("image");
		Thread thread = new Thread(thread_name, desc, img);
		thread.setThread_id(thread_id);
		Boolean rs = ThreadDAO.updateThread(thread);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-thread");
		dispatcher.forward(request, response);
	}
}
