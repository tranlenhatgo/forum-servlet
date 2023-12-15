package com.myproject.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.connection.DBConn;
import com.myproject.dao.UserDAO;
import com.myproject.model.User;

@WebServlet
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = UserDAO.userLogin(email, password);
			if (user!=null && user.getAdmin()==1) {
				System.out.println("Admin "+email+" is logined");
				request.getSession().setAttribute("admin", user);
				response.sendRedirect("home");
			} else {
				//send other attribute
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
