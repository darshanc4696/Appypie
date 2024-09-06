package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoimpls.UserDAOImpl;
import com.tap.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phoneNumber = req.getParameter("phoneNumber");
		String address = req.getParameter("address");
		String password = req.getParameter("password");
		
		User user = new User(name, password, email, phoneNumber, address);
		
		UserDAOImpl udaoi = new UserDAOImpl();
		int status = udaoi.addUser(user);
		
		if(status == 1)
		{
			resp.sendRedirect("success.jsp");
		}
		else
		{
			resp.sendRedirect("useralreadyfound.jsp");
		}
		
	}

}
