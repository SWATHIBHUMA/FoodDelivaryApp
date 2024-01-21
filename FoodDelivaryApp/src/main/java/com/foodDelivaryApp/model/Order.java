package com.foodDelivaryApp.model;

public class Order {
	private int orderid;
	private int userid;
	private int restaurentid;
	private int totalamount;
	private String status;
	private String paymentmethod;
	
	public Order() {
		
	}
	public Order(int orderid, int userid, int restaurentid, int totalamount, String status, String paymentmethod) {
		super();
		this.orderid = orderid;
		this.userid = userid;
		this.restaurentid = restaurentid;
		this.totalamount = totalamount;
		this.status = status;
		this.paymentmethod = paymentmethod;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRestaurentid() {
		return restaurentid;
	}
	public void setRestaurentid(int restaurentid) {
		this.restaurentid = restaurentid;
	}
	public int getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", userid=" + userid + ", restaurentid=" + restaurentid + ", totalamount="
				+ totalamount + ", status=" + status + ", paymentmethod=" + paymentmethod + "]";
	}
	
	
}
