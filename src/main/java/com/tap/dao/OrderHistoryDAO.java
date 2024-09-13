package com.tap.dao;

import java.util.List;

import com.tap.model.OrderHistory;

public interface OrderHistoryDAO 
{
	int addOrderHistory(OrderHistory oh);
	List<OrderHistory> getOrderHistory(int userId);

}
