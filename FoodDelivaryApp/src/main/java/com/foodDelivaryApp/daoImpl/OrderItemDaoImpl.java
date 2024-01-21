package com.foodDelivaryApp.daoImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodDelivaryApp.dao.OrderItemDao;
import com.foodDelivaryApp.model.OrderItem;

public class OrderItemDaoImpl implements OrderItemDao{

	static PreparedStatement preparedStatement;
	static Statement statement;
	static ResultSet res;
	
	private static final String ADD_ORDER_ITEM_QUERY = "INSERT INTO orderitem (OrderItemID, OrderID, MenuID, Quantity, ItemTotal) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_ORDER_ITEM_QUERY = "SELECT * FROM orderitem WHERE OrderItemID = ?";
    private static final String UPDATE_ORDER_ITEM_QUERY = "UPDATE orderitem SET OrderID=?, MenuID=?, Quantity=?, ItemTotal=? WHERE OrderItemID=?";
    private static final String DELETE_ORDER_ITEM_QUERY = "DELETE FROM orderitem WHERE OrderItemID=?";
    private static final String GET_ALL_ORDER_ITEMS_BY_ORDER_QUERY = "SELECT * FROM orderitem WHERE OrderID=?";
	
	@Override
	public void addOrderItem(OrderItem orderitem) {
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(ADD_ORDER_ITEM_QUERY);
			
			preparedStatement.setInt(1, orderitem.getOrderitemid());
			preparedStatement.setInt(2, orderitem.getOrderid());
			preparedStatement.setInt(3, orderitem.getMenuid());
			preparedStatement.setInt(4, orderitem.getQuantity());
			preparedStatement.setInt(5, orderitem.getTotalitem());
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public OrderItem getOrderItem(int orderitemId) {
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(GET_ORDER_ITEM_QUERY);
			res = preparedStatement.executeQuery();
			
			if(res.next()) {
				int orderitemid = res.getInt("OrderItemID");
				int orderid = res.getInt("OrderID");
				int menuid = res.getInt("MenuID");
				int quantity = res.getInt("Quantity");
				int totalitem = res.getInt("ItemTotal");
				
				return new OrderItem(orderitemid,orderid,menuid,quantity,totalitem);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void updateOrderItem(OrderItem orderitem) {
		
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(UPDATE_ORDER_ITEM_QUERY);
			
			preparedStatement.setInt(1, orderitem.getOrderitemid());
			preparedStatement.setInt(2, orderitem.getOrderid());
			preparedStatement.setInt(3, orderitem.getMenuid());
			preparedStatement.setInt(4, orderitem.getQuantity());
			preparedStatement.setInt(5, orderitem.getTotalitem());
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteOrderItem(int orderitemId) {
		
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(DELETE_ORDER_ITEM_QUERY);
			preparedStatement.setInt(1, orderitemId);
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<OrderItem> getAllOrderItemsByOrder(int orderId) {
		
		List<OrderItem> orderitemlist = new ArrayList<>();

		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(GET_ALL_ORDER_ITEMS_BY_ORDER_QUERY);
			preparedStatement.setInt(2, orderId);
			
			res = preparedStatement.executeQuery(GET_ALL_ORDER_ITEMS_BY_ORDER_QUERY);

			while (res.next()) {

				int orderitemid = res.getInt("OrderItemID");
				int orderid = res.getInt("OrderID");
				int menuid = res.getInt("MenuID");
				int quantity = res.getInt("Quantity");
				int totalitem = res.getInt("ItemTotal");
				
				OrderItem orders = new OrderItem(orderitemid,orderid,menuid,quantity,totalitem);
				orderitemlist.add(orders);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderitemlist;
	}
}
