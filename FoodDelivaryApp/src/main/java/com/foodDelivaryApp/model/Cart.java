package com.foodDelivaryApp.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<Integer,CartItem> cartItems;
	public Cart() {
		this.cartItems = new HashMap<>();
	}
	public void addItem(CartItem item) {
		int itemId = item.getItemId();
		if(cartItems.containsKey(itemId)) {
			CartItem existingItem= cartItems.get(itemId);
			existingItem.setQuantity(existingItem.getQuantity()+item.getQuantity());
		}
		else {
			cartItems.put(itemId, item);
		}
		
	}
	public void updateItem(int itemId, int quantity) {
		if(cartItems.containsKey(itemId)) {
			if(quantity<0) {
				cartItems.remove(itemId);
			}
			else {
				cartItems.get(itemId).setQuantity(quantity);
			}
		}
		
	}
	public void removeItem(int itemId) {
		cartItems.remove(itemId);
		
	}
	public Map<Integer, CartItem> getItems() {
		return cartItems;
		
	}
	
	public void clear() {
		cartItems.clear();
	}
	
	public CartItem getCartItem(int itemId) {
	    return cartItems.get(itemId);
	}

}
