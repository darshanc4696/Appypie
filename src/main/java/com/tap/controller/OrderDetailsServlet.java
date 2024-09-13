package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpls.OrderItemDAOImpl;
import com.tap.model.OrderItem;

@WebServlet("/orderdetails")
public class OrderDetailsServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int orderId = Integer.parseInt(req.getParameter("orderId"));
		
		OrderItemDAOImpl oidaoi = new OrderItemDAOImpl();
		
		List<OrderItem> orderDetails = oidaoi.fetchSpecificOrder(orderId);
		
		HttpSession session = req.getSession();
		session.setAttribute("orderDetails", orderDetails);
		
		resp.sendRedirect("orderdetails.jsp");
	}
}
