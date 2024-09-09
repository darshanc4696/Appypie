package com.tap.daoimpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.MenuDAO;
import com.tap.model.Menu;
import com.tap.utils.MyConnection;

public class MenuDAOImpl implements MenuDAO
{
	private Connection connection;
	private PreparedStatement pstmt;
	private int status;
	private Statement stmt;
	private ResultSet resultSet;
	private Menu menu;

	private static final String ADD_MENU_ITEM = "insert into menu(restaurantId, itemName, price, description, isAvailable) values(?,?,?,?,?)";
	private static final String SELECT_ALL_MENU = "select * from menu";
	private static final String SELECT_SPECIFIC_MENU = "select * from menu where restaurantId=?";
	private static final String UPDATE_SPECIFIC_MENU = "update menu set restaurantId=?, itemName=?, price=?, description=?, isAvailable=? where menuId=?";
	private static final String DELETE_MENU = "delete from menu where menuId=? and restaurantId=?";
	
	ArrayList<Menu> menuList = new ArrayList<Menu>();

	public MenuDAOImpl()
	{
		connection = MyConnection.myConnect();
	}

	@Override
	public int addMenuItem(Menu m) 
	{
		try
		{
			pstmt = connection.prepareStatement(ADD_MENU_ITEM);
			pstmt.setInt(1, m.getRestaurantId());
			pstmt.setString(2, m.getItemName());
			pstmt.setFloat(3, m.getPrice());
			pstmt.setString(4, m.getDescription());
			pstmt.setBoolean(5, m.getisAvailable());	
			status = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Menu> fetchAllMenu() 
	{
		try
		{
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(SELECT_ALL_MENU);
			menuList = extractAllMenuFromResultSet(resultSet);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return menuList;
	}
	
	public ArrayList<Menu> extractAllMenuFromResultSet(ResultSet resultSet)
	{
		try
		{
			while(resultSet.next())
			{
				menuList.add(new Menu(resultSet.getInt("menuId"),
						resultSet.getInt("restaurantId"),
						resultSet.getString("ItemName"),
						resultSet.getFloat("price"),
						resultSet.getString("description"),
						resultSet.getBoolean("isAvailable"),
						resultSet.getString("imgPath")
						));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return menuList;
	}

	@Override
	public List<Menu> fetchSpecificMenuItem(int restaurantId) 
	{
		try
		{
			pstmt = connection.prepareStatement(SELECT_SPECIFIC_MENU);
			
			pstmt.setInt(1, restaurantId);
			
			resultSet = pstmt.executeQuery();
			menuList = extractAllMenuFromResultSet(resultSet);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return menuList;
	}

	@Override
	public int updateMenuItem(Menu m) 
	{
		try
		{
			pstmt = connection.prepareStatement(UPDATE_SPECIFIC_MENU);
			pstmt.setInt(1,m.getRestaurantId());
			pstmt.setString(2, m.getItemName());
			pstmt.setFloat(3, m.getPrice());
			pstmt.setString(4, m.getDescription());
			pstmt.setBoolean(5, m.getisAvailable());
			pstmt.setInt(6, m.getMenuId());
			status = pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteMenuItem(int menuId, int restaurantId) 
	{
		try
		{
			pstmt = connection.prepareStatement(DELETE_MENU);
			pstmt.setInt(1, menuId);
			pstmt.setInt(2, restaurantId);
			status = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}
