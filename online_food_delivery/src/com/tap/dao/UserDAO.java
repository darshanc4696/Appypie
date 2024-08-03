package com.tap.dao;

import java.util.List;

import com.tap.model.User;

public interface UserDAO 
{
	int insertUser(User e);
	
	int deleteUser(int user_id);
	
	List<User> fetchAllUser();
	
	User fetchUser(int user_id);
	
	int updatePasswordOnUserID(int user_id, String password);

}
