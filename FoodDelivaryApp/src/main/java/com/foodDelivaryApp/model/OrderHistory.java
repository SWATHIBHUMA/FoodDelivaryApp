package com.foodDelivaryApp.model;

public class OrderHistory {
	private int orderhistoryid;
	private int userid;
	private int orderid;
	private int totalamount;
	private String status;
	
	public OrderHistory() {
		
	}
	public OrderHistory(int orderhistoryid, int userid, int orderid, int totalamount, String status) {
		super();
		this.orderhistoryid = orderhistoryid;
		this.userid = userid;
		this.orderid = orderid;
		this.totalamount = totalamount;
		this.status = status;
	}
	
	public int getOrderhistoryid() {
		return orderhistoryid;
	}
	public void setOrderhistoryid(int orderhistoryid) {
		this.orderhistoryid = orderhistoryid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
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

	@Override
	public String toString() {
		return "OrderHistory [orderhistoryid=" + orderhistoryid + ", userid=" + userid + ", orderid=" + orderid
				+ ", totalamount=" + totalamount + ", status=" + status + "]";
	}
	
	
}
