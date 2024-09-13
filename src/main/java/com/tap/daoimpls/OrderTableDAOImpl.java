package com.tap.daoimpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderTableDAO;
import com.tap.model.OrderTable;
import com.tap.utils.MyConnection;

public class OrderTableDAOImpl implements OrderTableDAO
{
	private Connection connection;

	private PreparedStatement pstmt;

	private int status;

	private Statement stmt;

	private ResultSet resultSet;
	
	ArrayList<OrderTable> orderTableList = new ArrayList<OrderTable>();

	private OrderTable orderTable;
	
	private static final String ADD_Order = "insert into ordertable(restaurantId, userId, totalAmount, status, paymentMode) values (?,?,?,?,?)";
	private static final String SELECT_ALL_ORDERS = "select * from ordertable";
	private static final String SELECT_SPECIFIC_ORDER = "select * from ordertable where restaurantId=? and userId=?";
	private static final String GET_MAXORDERID = "select max(orderId) from ordertable";
	
	public OrderTableDAOImpl()
	{
		connection = MyConnection.myConnect();
	}
	@Override
	public int addOrder(OrderTable o) 
	{
		try
		{
			pstmt = connection.prepareStatement(ADD_Order);
			pstmt.setInt(1, o.getRestaurantId());
			pstmt.setInt(2, o.getUserId());
			pstmt.setDouble(3, o.getTotalAmount());
			pstmt.setString(4, o.getStatus());
			pstmt.setString(5, o.getPaymentMode());
			
			status = pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<OrderTable> fetchAllOrders() 
	{
		try
		{
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(SELECT_ALL_ORDERS);
			orderTableList = extractOrdersFromResultSet(resultSet);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderTableList;
	}
	
	public ArrayList<OrderTable> extractOrdersFromResultSet(ResultSet resultSet)
	{
		try
		{
			orderTableList.add(new OrderTable(resultSet.getInt("orderId"),
					resultSet.getInt("restaurantId"),
					resultSet.getInt("userId"),
					resultSet.getString("orderDate"),
					resultSet.getFloat("price"),
					resultSet.getString("status"),
					resultSet.getString("paymentMode")
					));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return orderTableList;
	}

	@Override
	public OrderTable fetchSpecificOrder(int restaurantId, int userId) 
	{
		try
		{
			pstmt = connection.prepareStatement(SELECT_SPECIFIC_ORDER);
			
			pstmt.setInt(1, restaurantId);
			pstmt.setInt(2, userId);
			resultSet = pstmt.executeQuery();
			orderTableList = extractOrdersFromResultSet(resultSet);
			orderTable = orderTableList.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderTable;
	}
	
	@Override
	public int getLatestOrderId()
	{
		int maxId = 0;
		try 
		{
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(GET_MAXORDERID);
			
			if (resultSet.next()) 
	        {
	            maxId = resultSet.getInt(1);
	        }
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return maxId;
	}

}
