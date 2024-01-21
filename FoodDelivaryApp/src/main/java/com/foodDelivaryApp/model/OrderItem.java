package com.foodDelivaryApp.model;

public class OrderItem {
	private int orderitemid;
	private int orderid;
	private int menuid;
	private int quantity;
	private int totalitem;
	
	public OrderItem() {
		
	}

	public OrderItem(int orderitemid, int orderid, int menuid, int quantity, int totalitem) {
		super();
		this.orderitemid = orderitemid;
		this.orderid = orderid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.totalitem = totalitem;
	}

	public int getOrderitemid() {
		return orderitemid;
	}

	public void setOrderitemid(int orderitemid) {
		this.orderitemid = orderitemid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalitem() {
		return totalitem;
	}

	public void setTotalitem(int totalitem) {
		this.totalitem = totalitem;
	}

	@Override
	public String toString() {
		return "OrderItem [orderitemid=" + orderitemid + ", orderid=" + orderid + ", menuid=" + menuid + ", quantity="
				+ quantity + ", totalitem=" + totalitem + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
