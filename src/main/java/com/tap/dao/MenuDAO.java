package com.tap.dao;

import java.util.List;

import com.tap.model.Menu;


public interface MenuDAO
{
	int addMenuItem(Menu m);
	List<Menu> fetchAllMenu();
	List<Menu> fetchSpecificMenuItem(int restaurantId);		
	int updateMenuItem(Menu m);
	int deleteMenuItem(int menuId, int restaurantId);
	Menu getMenuItem(int menuId);
	
}
