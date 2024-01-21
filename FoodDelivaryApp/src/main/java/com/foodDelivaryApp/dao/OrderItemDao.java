package com.foodDelivaryApp.dao;

import java.util.List;
import com.foodDelivaryApp.model.OrderItem;

public interface OrderItemDao {
	void addOrderItem(OrderItem orderitem);
	OrderItem getOrderItem(int orderitemId);
	void updateOrderItem(OrderItem orderitem);
	void deleteOrderItem(int orderitemId);
	List<OrderItem> getAllOrderItemsByOrder(int orderId);
}
