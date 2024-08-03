package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.tap.dao.UserDAO;
import com.tap.model.User;
import com.tap.util.MyConnection;

public class UserDAOImpl implements UserDAO
{

	private MyConnection myCon;
	private Connection connection;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	
	

	public UserDAOImpl() {
		myCon = MyConnection.getMyConnection();
		connection = myCon.connect();
	}

	@Override
	public int insertUser(User u) 
	{
		try 
		{
			pstmt=connection.prepareStatement("insert into user(user_id, username, password, email, address, role, createDate, lastLoginDate) values (?,?,?,?,?,?,?)");
			
			pstmt.setInt(1, u.getUserId());
			pstmt.setString(2, u.getUsername());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getAddress());
			pstmt.setString(7, u.getCreateDate());
			pstmt.setString(8, u.getLastLogin());
			
			return pstmt.executeUpdate();
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteUser(int userId) 
	{
		try 
		{
			pstmt=connection.prepareStatement("delete from user where userId=?");
			
			pstmt.setInt(1, userId);
			
			return pstmt.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<User> fetchAllUser() 
	{
		try 
		{
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from user");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"    "+rs.getString(2)+"           "+rs.getString(3)+"           "+rs.getString(4)+"           "+rs.getString(5)+"           "+rs.getString(6)+"           "+rs.getString(7)+"           "+rs.getString(8));
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User fetchUser(int userId) 
	{
		try 
		{
			pstmt = connection.prepareStatement("select * from user where userId=?");
			
			pstmt.setInt(1, userId);
			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"    "+rs.getString(2)+"           "+rs.getString(3)+"           "+rs.getString(4)+"           "+rs.getString(5)+"           "+rs.getString(6)+"           "+rs.getString(7)+"           "+rs.getString(8));
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int updatePasswordOnUserID(int userId, String password) 
	{
		try 
		{
			pstmt=connection.prepareStatement("update user set password = ? where user_id=? ");
			
			pstmt.setString(1, password);
			pstmt.setInt(2, userId);
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return 0;
	}

}
