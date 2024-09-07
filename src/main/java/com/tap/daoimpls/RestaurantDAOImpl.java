package com.tap.daoimpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.RestaurantDAO;
import com.tap.model.Restaurant;
import com.tap.utils.MyConnection;

public class RestaurantDAOImpl implements RestaurantDAO
{
	private static final String ADD_RESTAURANT = "insert into restaurant(restaurantName, deliveryTime, cuisineType, address, ratings, isActive) values (?,?,?,?,?,?)";
	private static final String SELECT_ALL_RESTAURANT = "select * from restaurant";
	private static final String SELECT_ON_RESTAURANTID = "select * from restaurant where restaurantId=?";
	private static final String UPDATE_ON_RESTAURANTID = "update restaurant set restaurantName=?, deliveryTime=?, cuisineType=?, address=?, ratings=?, isActive=? where restaurantId=?";
	private static final String DELETE_ON_RESTAURANTID = "delete from restaurant where restaurantId=?";
	private Connection connection;
	private PreparedStatement pstmt;
	private int Status;
	private Statement stmt;
	private ResultSet resultSet;
	
	ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
	private Restaurant restaurant;

	
	public RestaurantDAOImpl()
	{
		connection = MyConnection.myConnect();
	}
	
	@Override
	public int addRestaurant(Restaurant r) 
	{
		try
		{
			pstmt = connection.prepareStatement(ADD_RESTAURANT);
			
			pstmt.setString(1, r.getRestaurantName());
			pstmt.setInt(2, r.getDeliveryTime());
			pstmt.setString(3, r.getCuisineType());
			pstmt.setString(4, r.getAddress());
			pstmt.setFloat(5, r.getRatings());
			pstmt.setBoolean(6, r.getisActive());
			
			Status = pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Status;
	}

	@Override
	public List<Restaurant> fetchAllRestaurant() 
	{
		try
		{
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(SELECT_ALL_RESTAURANT);
			restaurantList = extractRestaurantFromResultSet(resultSet);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return restaurantList;
	}

	private ArrayList<Restaurant> extractRestaurantFromResultSet(ResultSet resultSet) 
	{
		try
		{
			while(resultSet.next())
			{
				restaurantList.add(new Restaurant(resultSet.getInt("restaurantId"),
						resultSet.getString("restaurantName"),
						resultSet.getInt("deliveryTime"),
						resultSet.getString("cuisineType"),
						resultSet.getString("address"),
						resultSet.getFloat("ratings"),
						resultSet.getBoolean("isActive"),
						resultSet.getInt("adminId"),
						resultSet.getString("imgPath")
						));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return restaurantList;
		
		
	}

	@Override
	public Restaurant fetchSpecificRestaurant(int restaurantId) 
	{
		try
		{
			pstmt = connection.prepareStatement(SELECT_ON_RESTAURANTID);
			
			pstmt.setInt(1, restaurantId);
			resultSet = pstmt.executeQuery();
			restaurantList = extractRestaurantFromResultSet(resultSet);
			
			restaurant = restaurantList.get(0);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return restaurant;
	}

	@Override
	public int updateRestaurant(Restaurant r) 
	{
		try
		{
			pstmt = connection.prepareStatement(UPDATE_ON_RESTAURANTID);
			
			pstmt.setString(1, r.getRestaurantName());
			pstmt.setInt(2, r.getDeliveryTime());
			pstmt.setString(3, r.getCuisineType());
			pstmt.setString(4, r.getAddress());
			pstmt.setFloat(5, r.getRatings());
			pstmt.setBoolean(6, r.getisActive());
			pstmt.setInt(7, r.getRestaurantId());
			
			Status = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Status;
	}

	@Override
	public int deleteRestaurant(int restaurantId) 
	{
		try
		{
			pstmt = connection.prepareStatement(DELETE_ON_RESTAURANTID);
			
			pstmt.setInt(1, restaurantId);
			
			Status = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Status;
	}
	

}
