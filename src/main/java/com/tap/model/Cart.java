package com.tap.model;

import java.util.HashMap;
import java.util.Map;

public class Cart 
{
	private Map<Integer, CartItem> items;
	
	public Cart()
	{
		this.items = new HashMap<>();
	}
	
	public void addItem(CartItem item)
	{
		int itemId = item.getItemId();
		
		if(items.containsKey(itemId))
		{
			CartItem existingItem = items.get(itemId);
			existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity()); 
		}
		else
		{
			items.put(itemId, item);
		}
	}
	
	public void updateItem(int itemId, int quantity)
	{
		if(items.containsKey(itemId))
		{
			if(quantity <= 0)
			{
				items.remove(itemId);
			}
			else
			{
				items.get(itemId).setQuantity(quantity);
				items.get(itemId).setSubTotal((items.get(itemId).getPrice())*quantity);;
			}
		}
	}
	
	public void removeItem(int itemId)
	{
		items.remove(itemId);
	}
	
	public Map<Integer, CartItem> getItems()
	{
		return items;
	}
	
	public void clearCart()
	{
		items.clear();
	}
	
	public int getTotal()
	{
		int total=0;
		
		for(Map.Entry<Integer, CartItem> item : items.entrySet())
		{
			total += item.getValue().getSubTotal();
		}
		
		return total;
	}

}
