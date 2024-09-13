package com.tap.daoimpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderHistoryDAO;
import com.tap.model.OrderHistory;
import com.tap.model.User;
import com.tap.utils.MyConnection;

public class OrderHistoryDAOImpl implements OrderHistoryDAO
{
	private static final String ADD_ORDERHISTORY = "insert into orderhistory(orderId, userId, totalAmount, status) values (?,?,?,?)";
	private static final String SELECT_SPECIFIC_ORDERHISTORY = "select * from orderhistory where userId = ?";
	private Connection connection;
	private PreparedStatement pstmt;
	private int status;
	private ResultSet resultSet;
	ArrayList<OrderHistory> orderhistoryList = new ArrayList<OrderHistory>();
	

	public OrderHistoryDAOImpl()
	{
		connection = MyConnection.myConnect();
	}

	@Override
	public int addOrderHistory(OrderHistory oh) 
	{
		try 
		{
			pstmt = connection.prepareStatement(ADD_ORDERHISTORY);
			pstmt.setInt(1, oh.getOrderId());
			pstmt.setInt(2, oh.getUserId());
			pstmt.setDouble(3, oh.getTotalAmount());
			pstmt.setString(4, oh.getStatus());
			
			status = pstmt.executeUpdate();

		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		return status;
	}

	@Override
	public List<OrderHistory> getOrderHistory(int userId) 
	{
		try 
		{
			pstmt = connection.prepareStatement(SELECT_SPECIFIC_ORDERHISTORY);
			pstmt.setInt(1, userId);
			
			resultSet = pstmt.executeQuery();
			orderhistoryList = extractOrderHistoryFromResultSet(resultSet);

		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return orderhistoryList;
	}

	private ArrayList<OrderHistory> extractOrderHistoryFromResultSet(ResultSet resultSet2) 
	{
		try 
		{
			while(resultSet.next())
			{
				orderhistoryList.add(new OrderHistory(resultSet.getInt("orderHistoryId"), 
								resultSet.getInt("orderId"), 	
								resultSet.getInt("userId"),	 
								resultSet.getString("orderDate"),
								resultSet.getDouble("totalAmount"),
								resultSet.getString("status")));
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return orderhistoryList;
	}

}
