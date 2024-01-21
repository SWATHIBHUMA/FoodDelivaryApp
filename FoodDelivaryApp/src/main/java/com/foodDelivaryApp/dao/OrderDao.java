package com.foodDelivaryApp.dao;

import java.util.List;
import com.foodDelivaryApp.model.Order;

public interface OrderDao {
	void addOrder(Order order);
	Order getOrder(int orderId);
	void updateOrder(Order order);
	void deleteOrder(int OrderId);
	List<Order> getAllOrdersByUser(int userId);
}
