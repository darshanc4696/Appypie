package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpls.MenuDAOImpl;
import com.tap.daoimpls.RestaurantDAOImpl;
import com.tap.model.Menu;
import com.tap.model.Restaurant;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		MenuDAOImpl mdaoi = new MenuDAOImpl();
		List<Menu> menuItems = mdaoi.fetchSpecificMenuItem(restaurantId);
		
		RestaurantDAOImpl rdaoi = new RestaurantDAOImpl();
		Restaurant restaurant = rdaoi.fetchSpecificRestaurant(restaurantId);
		
		HttpSession session = req.getSession();
		session.setAttribute("menuItems", menuItems);
		session.setAttribute("restaurantName", restaurant.getRestaurantName());
		
		resp.sendRedirect("menu.jsp");
	}
	
}
