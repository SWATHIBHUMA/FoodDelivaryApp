package com.foodDelivaryApp.dao;

import java.util.List;
import com.foodDelivaryApp.model.OrderHistory;

public interface OrderHistoryDao {
	void addOrderHistory(OrderHistory orderHistory);
	OrderHistory getOrderHistory(int orderhistoryId);
	void updateOrderHistory(OrderHistory orderHistory);
	void deleteOrderHistory(int OrderHistoryId);
	List<OrderHistory> getOrderHistoriesByUser(int userId);
}
