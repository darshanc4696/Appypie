package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpls.OrderHistoryDAOImpl;
import com.tap.model.OrderHistory;
import com.tap.model.User;


@WebServlet("/orderhistory")
public class OrderHistoryServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		User loggedInUser = (User)session.getAttribute("loggedInUser");

		int userId = loggedInUser.getUserId();
		OrderHistoryDAOImpl ohdaoi = new OrderHistoryDAOImpl();
		List<OrderHistory> orderhistoryList = ohdaoi.getOrderHistory(userId);
			
		session.setAttribute("orderhistoryList", orderhistoryList);
			
		resp.sendRedirect("orderhistory.jsp");

	}
}
