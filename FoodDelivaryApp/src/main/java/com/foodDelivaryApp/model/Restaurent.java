package com.foodDelivaryApp.model;

public class Restaurent {
	private int restaurentid;
	private String name;
	private String address;
	private float rating;
	private String cuisinetype;
	private boolean isactive;
	private int eta;
	private int adminuserid;
	private String imagePath;
	public Restaurent() {
		
	}
	
	public Restaurent(int restaurentid, String name, String address, float rating, String cuisinetype, boolean isactive,
			int eta, int adminuserid, String imagePath) {
		super();
		this.restaurentid = restaurentid;
		this.name = name;
		this.address = address;
		this.rating = rating;
		this.cuisinetype = cuisinetype;
		this.isactive = isactive;
		this.eta = eta;
		this.adminuserid = adminuserid;
		this.imagePath = imagePath;
	}
	public int getRestaurentid() {
		return restaurentid;
	}
	public void setRestaurentid(int restaurentid) {
		this.restaurentid = restaurentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getCuisinetype() {
		return cuisinetype;
	}
	public void setCuisinetype(String cuisinetype) {
		this.cuisinetype = cuisinetype;
	}
	public boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public int getAdminuserid() {
		return adminuserid;
	}
	public void setAdminuserid(int adminuserid) {
		this.adminuserid = adminuserid;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@Override
	public String toString() {
		return "Restaurent [restaurentid=" + restaurentid + ", name=" + name + ", address=" + address + ", rating="
				+ rating + ", cuisinetype=" + cuisinetype + ", isactive=" + isactive + ", eta=" + eta + ", adminuserid="
				+ adminuserid + ", imagePath=" + imagePath + "]";
	}
	

}
