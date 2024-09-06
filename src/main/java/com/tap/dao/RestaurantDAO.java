package com.tap.dao;

import java.util.List;

import com.tap.model.Restaurant;

public interface RestaurantDAO 
{
	int addRestaurant(Restaurant r);
	List<Restaurant> fetchAllRestaurant();
	Restaurant fetchSpecificRestaurant(int restaurantId);		
	int updateRestaurant(Restaurant r);
	int deleteRestaurant(int restaurantId);
	
	

}
