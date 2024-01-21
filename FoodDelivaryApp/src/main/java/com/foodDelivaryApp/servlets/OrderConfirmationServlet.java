package com.foodDelivaryApp.servlets;

import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodDelivaryApp.Utilities.OrderIdGenerator;
import com.foodDelivaryApp.daoImpl.OrderDaoImpl;
import com.foodDelivaryApp.model.Order;
import com.foodDelivaryApp.model.User;

@WebServlet("/orderConfirmationServlet")
public class OrderConfirmationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        System.out.println("user in ocs: "+user);

        if (user == null) {
            response.sendRedirect("login.jsp?message=Please sign in or sign up to place an order");
            return;
        }

        int totalAmount = Integer.parseInt(request.getParameter("totalAmount"));
        String address = request.getParameter("address");
        int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
        String paymentMethod="cash";

        int userId = user.getUserId();
        String orderStatus = "Pending";

        LocalDateTime orderDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedOrderDate = orderDate.format(formatter);

        int orderId = OrderIdGenerator.generateOrderId();
        System.out.println("Before Parsing: "+orderId);

        Order order = new Order(orderId,userId, restaurantId, totalAmount, orderStatus, paymentMethod);
        System.out.println(order);
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.addOrder(order);
       	
        session.setAttribute("address", address);
        session.setAttribute("orderId", orderId);
        session.setAttribute("totalAmount", totalAmount);
        session.setAttribute("userId", userId);
        session.setAttribute("paymentStatus", "Pending");
        session.setAttribute("paymentMethod", paymentMethod);
        response.sendRedirect("orderConfirmation.jsp");        	
    }
}
