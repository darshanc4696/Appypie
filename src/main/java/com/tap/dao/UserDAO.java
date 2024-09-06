package com.tap.dao;

import java.util.List;

import com.tap.model.User;

public interface UserDAO 
{
	int addUser(User u);
	List<User> fetchAllUsers();
	User fetchUser(String email);		
	int updateUser(User u);
	int deleteUser(String email);

}
