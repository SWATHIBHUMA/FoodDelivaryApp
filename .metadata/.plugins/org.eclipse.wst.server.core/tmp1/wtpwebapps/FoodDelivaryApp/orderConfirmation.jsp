<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Objects" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    //HttpSession session = request.getSession();
    Integer orderId = (Integer) session.getAttribute("orderId");
    Integer totalAmount = (Integer) session.getAttribute("totalAmount");
    Integer userId = (Integer) session.getAttribute("userId");
    String paymentStatus = (String) session.getAttribute("paymentStatus");
    String paymentMethod = (String) session.getAttribute("paymentMethod");
    String address = (String) session.getAttribute("address");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/OrderConfirmation.css" type="text/css">
    <title>Order Confirmation</title>
</head>
<body>
    <div class="container">
        <h1>Order Successfull...</h1>
        <h4>Thank You for your Order</h4>
		<hr>
        <div class="form-group">
            <label class="form-label">Order ID:</label>
            <p><%= orderId %></p>
        </div>

		<div class="form-group">
            <label class="form-label">User ID:</label>
            <p><%= userId %></p>
        </div>
        
        <div class="form-group">
            <label class="form-label">Total Amount:</label>
            <p><%= totalAmount %></p>
        </div>

        <div class="form-group">
            <label class="form-label">Payment Method:</label>
            <p><%= paymentMethod %></p>
        </div>
        
        <div class="form-group">
            <label class="form-label">Payment Status:</label>
            <p><%= paymentStatus %></p>
        </div>
        
        

		<div class="container-1">
        	<button onclick="window.location.href='<%= request.getContextPath() %>/Restaurents'">Explore Restaurants</button>
		</div>
    </div>
</body>
</html>
