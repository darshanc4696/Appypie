package com.tap.utils;

import java.sql.Connection;
import java.sql.DriverManager;

final public class MyConnection 
{
	private static Connection con = null;
	private static String url = "jdbc:mysql://localhost:3306/Appypie";
	private static String username = "root";
	private static String password = "2002@Abcd";

	public static Connection myConnect()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return con;
		
	}
	
}
