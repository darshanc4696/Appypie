package com.tap.dao;

import java.util.List;

import com.tap.model.OrderItem;


public interface OrderItemDAO 
{
	int addOrderItem(OrderItem oi);
	List<OrderItem> fetchAllOrders();
	OrderItem fetchSpecificOrder(int orderId, int menuId);	

}
