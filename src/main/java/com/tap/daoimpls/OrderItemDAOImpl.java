package com.tap.daoimpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.tap.dao.OrderItemDAO;
import com.tap.model.OrderItem;
import com.tap.utils.MyConnection;

public class OrderItemDAOImpl implements OrderItemDAO
{
	
	private Connection connection;

	private PreparedStatement pstmt;

	private int status;

	private Object stmt;
	
	private static final String ADD_ORDERITEM = "insert into orderitem(orderId, menuId, quantity, subTotal) values (?,?,?,?)";
	private static final String SELECT_ALL_ORDERITEMS = "select * from orderitem";
	private static final String SELECT_SPECIFIC_ORDERITEM = "select * from orderitem where orderId=? and menuId=?";

	public OrderItemDAOImpl()
	{
		connection = MyConnection.myConnect();
	}

	@Override
	public int addOrderItem(OrderItem oi) 
	{
		try
		{
			pstmt = connection.prepareStatement(ADD_ORDERITEM);
			
			pstmt.setInt(1, oi.getOrderId());
			pstmt.setInt(2, oi.getMenuId());
			pstmt.setInt(3, oi.getQuantity());
			pstmt.setFloat(4, oi.getSubTotal());
			
			status = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public List<OrderItem> fetchAllOrders() 
	{
		try
		{
			stmt = connection.createStatement();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public OrderItem fetchSpecificOrder(int orderId, int menuId) 
	{
		try
		{
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	

}
