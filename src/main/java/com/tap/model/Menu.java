package com.tap.model;

public class Menu 
{
	
	private int menuId;
	private int restaurantId;
	private String itemName;
	private float price;
	private String description;
	private boolean isAvailable;
	private String imgPath;
	
	public Menu(int restaurantId, String itemName, float price, String description, boolean isAvailable) {
		super();
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
	}

	public Menu(int menuId, int restaurantId, String itemName, float price, String description, boolean isAvailable) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
	}
	
	public Menu(int menuId, int restaurantId, String itemName, float price, String description, boolean isAvailable, String imgPath) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
		this.imgPath = imgPath;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getisAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restaurantId=" + restaurantId + ", itemName=" + itemName + ", price="
				+ price + ", description=" + description + ", isAvailable=" + isAvailable + "]";
	}

}
