package com.tap.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpls.OrderHistoryDAOImpl;
import com.tap.daoimpls.OrderItemDAOImpl;
import com.tap.daoimpls.OrderTableDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.OrderHistory;
import com.tap.model.OrderItem;
import com.tap.model.OrderTable;
import com.tap.model.User;

@WebServlet("/fillordertables")
public class FillOrderTables extends HttpServlet
{
	
	public int status;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		User loggedInUser = (User)session.getAttribute("loggedInUser");
		
		if(loggedInUser != null)
		{

			int restaurantId = (int) session.getAttribute("restaurantId");
			double cartTotal = (double) session.getAttribute("carttotal");
			String paymentMode = req.getParameter("paymentMode");
			
			
			OrderTableDAOImpl otdaoi = new OrderTableDAOImpl();
			OrderItemDAOImpl oidaoi = new OrderItemDAOImpl();
			OrderHistoryDAOImpl ohdaoi = new OrderHistoryDAOImpl();
			Cart cart = (Cart)session.getAttribute("cart");
			Map<Integer, CartItem> items = cart.getItems();
			
			
			
			
			OrderTable ot = new OrderTable(restaurantId, loggedInUser.getUserId(), cartTotal, "pending", paymentMode);
			status = otdaoi.addOrder(ot);
			
			int latestOrderId = otdaoi.getLatestOrderId();
			for(Map.Entry<Integer, CartItem> item : items.entrySet())
			{

				OrderItem oi = new OrderItem(latestOrderId, item.getValue().getItemId(), item.getValue().getQuantity(), item.getValue().getSubTotal());
				status = oidaoi.addOrderItem(oi);
			}
			
			OrderHistory oh = new OrderHistory(latestOrderId, loggedInUser.getUserId(), cartTotal, "pending");
			status = ohdaoi.addOrderHistory(oh);
			
			resp.sendRedirect("orderconfirmed.jsp");
		}
		else
		{
			resp.sendRedirect("usernotloggedin.jsp");
		}


	}
}
