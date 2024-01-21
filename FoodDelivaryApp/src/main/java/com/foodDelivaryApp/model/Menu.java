package com.foodDelivaryApp.model;

public class Menu {
	private int menuid;
	private int restaurentid;
	private String itemname;
	private String description;
	private double price;
	private boolean isAvailable;
	private double ratings;
	private String imagePath;
	public Menu() {
		
	}
	
	public Menu(int menuid, int restaurentid, String itemname, String description, double price, boolean isAvailable,
			double ratings, String imagePath) {
		super();
		this.menuid = menuid;
		this.restaurentid = restaurentid;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.ratings = ratings;
		this.imagePath = imagePath;
	}

	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getRestaurentid() {
		return restaurentid;
	}
	public void setRestaurentid(int restaurentid) {
		this.restaurentid = restaurentid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public double getRatings() {
		return ratings;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", restaurentid=" + restaurentid + ", itemname=" + itemname + ", description="
				+ description + ", price=" + price + ", isAvailable=" + isAvailable + ", ratings=" + ratings
				+ ", imagePath=" + imagePath + "]";
	}
	
}
