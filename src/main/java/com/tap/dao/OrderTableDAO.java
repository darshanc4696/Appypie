package com.tap.dao;

import java.sql.ResultSet;
import java.util.List;

import com.tap.model.OrderTable;

public interface OrderTableDAO 
{
	int addOrder(OrderTable o);
	List<OrderTable> fetchAllOrders();
	OrderTable fetchSpecificOrder(int restaurantId, int userId);	
	int getLatestOrderId();
}
