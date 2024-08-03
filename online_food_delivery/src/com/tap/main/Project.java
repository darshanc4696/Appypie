package com.tap.main;

import java.util.Scanner;
import com.tap.daoimpl.UserDAOImpl;
import com.tap.model.User;

public class Project {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int user_id;
		String username,password,email,address,role,createDate,lastLoginDate;
		
		
//------------------------INSERTING---------------------------		
//		System.out.println("Enter userid: ");
//		user_id = sc.nextInt();
//		sc.nextLine();
//		System.out.println("Enter username: ");
//		username = sc.nextLine();
//		System.out.println("Enter password: ");
//		password = sc.nextLine();
//		System.out.println("Enter email: ");
//		email = sc.nextLine();
//		System.out.println("Enter address: ");
//		address = sc.nextLine();
//		System.out.println("Enter role: ");
//		role = sc.nextLine();
//		System.out.println("Enter createDate: ");
//		createDate = sc.nextLine();
//		System.out.println("Enter lastLoginDate: ");
//		lastLoginDate = sc.nextLine();

//		User usr = new User(user_id,username,password,email,address,role,createDate,lastLoginDate);
//		UserDAOImpl usrDAO = new UserDAOImpl();
//		int x = usrDAO.insertUser(usr);
//		System.out.println("Status: "+x);
		
		
//------------------------DELETING---------------------------		
//		System.out.println("Enter userid: ");
//		user_id = sc.nextInt();
//		UserDAOImpl usrDAO = new UserDAOImpl();
//		int x = usrDAO.deleteUser(user_id);
//		System.out.println("Status: "+x);
		
		
//------------------------FETCHING ALL USER ---------------------------		
//		UserDAOImpl usrDAO = new UserDAOImpl();
//		usrDAO.fetchAllUser();
		
		
//------------------------FETCHING USER ---------------------------		
//		System.out.println("Enter the userid to fetch the data: ");
//		user_id = sc.nextInt();
//		UserDAOImpl usrDAO = new UserDAOImpl();
//		usrDAO.fetchUser(user_id);
		
//------------------------UPDATING USER PASSWORD ---------------------------		
		System.out.println("Enter the userid to fetch the data: ");
		user_id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter password: ");
		password = sc.nextLine();
		UserDAOImpl usrDAO = new UserDAOImpl();
		int x = usrDAO.updatePasswordOnUserID(user_id, password);
		
		System.out.println("Status: "+x);
		

	}

}
