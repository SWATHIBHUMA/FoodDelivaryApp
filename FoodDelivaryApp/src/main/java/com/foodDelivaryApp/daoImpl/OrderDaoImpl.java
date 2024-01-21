package com.foodDelivaryApp.daoImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodDelivaryApp.dao.OrderDao;
import com.foodDelivaryApp.model.Order;

public class OrderDaoImpl implements OrderDao{
	
	static PreparedStatement preparedStatement;
	static Statement statement;
	static ResultSet res;
	
	private static final String INSERT_ORDER_QUERY = "INSERT INTO ordertable (OrderID, UserID, RestaurantID, TotalAmount, Status, PaymentMethod) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ORDER_QUERY = "SELECT * FROM ordertable WHERE OrderID = ?";
    private static final String UPDATE_ORDER_QUERY = "UPDATE ordertable SET UserID=?, RestaurantID=?, TotalAmount=?, Status=?, PaymentMethod=? WHERE OrderID=?";
    private static final String DELETE_ORDER_QUERY = "DELETE FROM ordertable WHERE OrderId=?";
    private static final String SELECT_ALL_ORDERS = "SELECT * FROM ordertable WHERE UserId=?";
	
	@Override
	public void addOrder(Order order) {
		
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(INSERT_ORDER_QUERY);
			
			preparedStatement.setInt(1, order.getOrderid());
			preparedStatement.setInt(2, order.getUserid());
			preparedStatement.setInt(3, order.getRestaurentid());
			preparedStatement.setInt(4, order.getTotalamount());
			preparedStatement.setString(5, order.getStatus());
			preparedStatement.setString(6, order.getPaymentmethod());
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Order getOrder(int orderId) {
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(SELECT_ORDER_QUERY);
			res = preparedStatement.executeQuery();
			
			
			if(res.next()) {
				int orderid = res.getInt("OrderID");
				int userid = res.getInt("UserID");
				int restaurentId = res.getInt("RestaurantID");
				int totalAmount = res.getInt("TotalAmount");
				String status = res.getString("Status");
				String paymentMethod = res.getString("PaymentMethod");
				
				return new Order(orderid,userid,restaurentId,totalAmount,status,paymentMethod);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateOrder(Order order) {
		
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(UPDATE_ORDER_QUERY);
			
			preparedStatement.setInt(1, order.getOrderid());
			preparedStatement.setInt(2, order.getRestaurentid());
			preparedStatement.setInt(3, order.getTotalamount());
			preparedStatement.setString(4, order.getStatus());
			preparedStatement.setString(5, order.getPaymentmethod());
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrder(int OrderId) {
		
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(DELETE_ORDER_QUERY);
			preparedStatement.setInt(1, OrderId);
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Order> getAllOrdersByUser(int userId) {
		List<Order> orderlist = new ArrayList<>();

		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS);
			preparedStatement.setInt(2, userId);
			
			res = preparedStatement.executeQuery(SELECT_ALL_ORDERS);

			while (res.next()) {
				
				int orderid = res.getInt("OrderID");
				int userid = res.getInt("UserID");
				int restaurentId = res.getInt("RestaurantID");
				int totalAmount = res.getInt("TotalAmount");
				String status = res.getString("Status");
				String paymentMethod = res.getString("PaymentMethod");

				Order orders = new Order(orderid,userid,restaurentId,totalAmount,status,paymentMethod);
				orderlist.add(orders);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderlist;

	}

}
