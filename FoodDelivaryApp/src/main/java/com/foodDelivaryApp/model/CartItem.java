package com.foodDelivaryApp.model;

import java.util.Objects;

public class CartItem {
	private int itemId;
	private int restaurentId;
	private String name;
	private int quantity;
	private double price;
	
	
	public CartItem() {
		super();
	}
	public CartItem(int itemId, int restaurentId, String name, int quantity, double price) {
		super();
		this.itemId = itemId;
		this.restaurentId = restaurentId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", restaurentId=" + restaurentId + ", name=" + name + ", quantity="
				+ quantity + ", price=" + price + "]";
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getRestaurentId() {
		return restaurentId;
	}
	public void setRestaurentId(int restaurentId) {
		this.restaurentId = restaurentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(itemId, name, price, quantity, restaurentId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		return itemId == other.itemId && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quantity == other.quantity
				&& restaurentId == other.restaurentId;
	}
}
