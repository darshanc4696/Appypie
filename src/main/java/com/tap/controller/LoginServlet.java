package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoimpls.UserDAOImpl;
import com.tap.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email = req.getParameter("email");
		
		UserDAOImpl udaoi = new UserDAOImpl();
		
		User user = udaoi.fetchUser(email);
		
		if(user != null)
		{
			String password = req.getParameter("password");
			if(user.getPassword().equals(password))
			{
				resp.sendRedirect("home.jsp");
			}
			else
			{
				resp.sendRedirect("passwordwrong.jsp");
			}
		}
		else
		{
			resp.sendRedirect("failure.jsp");
		}
	}
	

}
