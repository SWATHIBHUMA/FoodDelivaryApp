package com.foodDelivaryApp.daoImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodDelivaryApp.dao.OrderHistoryDao;
import com.foodDelivaryApp.model.OrderHistory;


public class OrderHistoryDaoImpl implements OrderHistoryDao{
	
	static PreparedStatement preparedStatement;
	static Statement statement;
	static ResultSet res;
	
	private static final String ADD_ORDER_HISTORY_QUERY = "INSERT INTO orderhistory (OrderHistoryID, UserID, OrderID, TotalAmount, Status) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_ORDER_HISTORY_QUERY = "SELECT * FROM orderhistory WHERE OrderHistoryID = ?";
    private static final String UPDATE_ORDER_HISTORY_QUERY = "UPDATE orderhistory SET UserID=?, OrderID=?, TotalAmount=?, Status=? WHERE OrderHistoryID=?";
    private static final String DELETE_ORDER_HISTORY_QUERY = "DELETE FROM orderhistory WHERE OrderHistoryID=?";
    private static final String GET_ORDER_HISTORIES_BY_USER_QUERY = "SELECT * FROM orderhistory WHERE UserID=?";
	
	@Override
	public void addOrderHistory(OrderHistory orderHistory) {
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(ADD_ORDER_HISTORY_QUERY);
			
			preparedStatement.setInt(1, orderHistory.getOrderhistoryid());
			preparedStatement.setInt(2, orderHistory.getUserid());
            preparedStatement.setInt(3, orderHistory.getOrderid());
            preparedStatement.setInt(4, orderHistory.getTotalamount());
            preparedStatement.setString(5, orderHistory.getStatus());
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderHistory getOrderHistory(int orderhistoryId) {
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(GET_ORDER_HISTORY_QUERY);
			res = preparedStatement.executeQuery();
			
			if(res.next()) {
				int orderhistoryitemid = res.getInt("OrderHistoryID");
				int userid = res.getInt("UserID");
				int orderid = res.getInt("OrderID");
				int totalitem = res.getInt("TotalAmount");
				String status = res.getString("Status");
				
				return new OrderHistory(orderhistoryitemid,userid,orderid,totalitem,status);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateOrderHistory(OrderHistory orderHistory) {
		
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(UPDATE_ORDER_HISTORY_QUERY);
			
			preparedStatement.setInt(1, orderHistory.getOrderhistoryid());
			preparedStatement.setInt(2, orderHistory.getUserid());
            preparedStatement.setInt(3, orderHistory.getOrderid());
            preparedStatement.setInt(4, orderHistory.getTotalamount());
            preparedStatement.setString(5, orderHistory.getStatus());
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrderHistory(int OrderHistoryId) {
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(DELETE_ORDER_HISTORY_QUERY);
			preparedStatement.setInt(1, OrderHistoryId);
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderHistory> getOrderHistoriesByUser(int userId) {
		
		List<OrderHistory> orderhistorylist = new ArrayList<>();

		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(GET_ORDER_HISTORIES_BY_USER_QUERY);
			preparedStatement.setInt(2, userId);
			
			res = preparedStatement.executeQuery(GET_ORDER_HISTORIES_BY_USER_QUERY);

			while (res.next()) {

				int orderhistoryitemid = res.getInt("OrderHistoryID");
				int userid = res.getInt("UserID");
				int orderid = res.getInt("OrderID");
				int totalitem = res.getInt("TotalAmount");
				String status = res.getString("Status");
				
				OrderHistory orderhistory = new OrderHistory(orderhistoryitemid,userid,orderid,totalitem,status);
				orderhistorylist.add(orderhistory);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderhistorylist;
	}
	
}
