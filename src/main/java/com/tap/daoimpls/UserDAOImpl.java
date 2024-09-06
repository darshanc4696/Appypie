package com.tap.daoimpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.UserDAO;
import com.tap.model.User;
import com.tap.utils.MyConnection;

public class UserDAOImpl implements UserDAO
{
	private Connection connection;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private int status;
	private User user;
	ArrayList<User> userList = new ArrayList<User>();
	private static final String ADD_User = "insert into user(username, email, phoneNumber, password, address) values (?,?,?,?,?)";
	private static final String SELECT_ALL_USERS = "select * from user";
	private static final String SELECT_On_Email = "select * from user where email=?";
	private static final String UPDATE_ON_EMAIL = "update user set username=?,phoneNumber=?, password=?, address=? where email=?";
	private static final String DELETE_ON_EMAIL = "delete from user where email=?";
	
	public UserDAOImpl() 
	{
		connection = MyConnection.myConnect();
	}

	@Override
	public int addUser(User u) 
	{
		try 
		{
			pstmt = connection.prepareStatement(ADD_User);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getPhoneNumber());
			pstmt.setString(4, u.getPassword());
			pstmt.setString(5, u.getAddress());
			
			status = pstmt.executeUpdate();
		} 
		catch (Exception e1) 
		{
			System.out.println("user found");
			e1.printStackTrace();
		}
		
		return status;
	}
	
	@Override
	public List<User> fetchAllUsers() 
	{
		try 
		{
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(SELECT_ALL_USERS);
			
			userList = extractUserFromResultSet(resultSet);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return userList;
	}
	
	@Override
	public User fetchUser(String email) 
	{
		try 
		{
			pstmt = connection.prepareStatement(SELECT_On_Email);
			pstmt.setString(1, email);
			
			resultSet = pstmt.executeQuery();
			userList = extractUserFromResultSet(resultSet);
			user = userList.get(0);	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public int updateUser(User u) 
	{
		try 
		{
			pstmt=connection.prepareStatement(UPDATE_ON_EMAIL);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPhoneNumber());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4, u.getAddress());
			pstmt.setString(5, u.getEmail());
			status = pstmt.executeUpdate();
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	@Override
	public int deleteUser(String email) 
	{
		try 
		{
			pstmt=connection.prepareStatement(DELETE_ON_EMAIL);
			pstmt.setString(1, email);
			
			status = pstmt.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public ArrayList<User> extractUserFromResultSet(ResultSet resultSet)
	{
		try 
		{	
			while(resultSet.next())
			{
				userList.add(new User(resultSet.getInt("userId"),
						resultSet.getString("username"),
						resultSet.getString("password"),
						resultSet.getString("email"),
						resultSet.getString("phoneNumber"),
						resultSet.getString("address")
						));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return userList;
		
	}

}
