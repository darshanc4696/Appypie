package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpls.RestaurantDAOImpl;
import com.tap.model.Restaurant;

@WebServlet("/home")
public class DisplayAllRestaurantServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RestaurantDAOImpl rdaoi = new RestaurantDAOImpl();
		List<Restaurant> restaurantList = rdaoi.fetchAllRestaurant();
		
		HttpSession session = req.getSession();
		session.setAttribute("restaurantList", restaurantList);
		
		resp.sendRedirect("/index.jsp");
	}
}
