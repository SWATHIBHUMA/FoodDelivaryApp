<%@ page import="java.util.Objects" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.io.IOException" %>
<%@ page import="com.foodDelivaryApp.model.User" %>
<%@ page import="com.foodDelivaryApp.model.Order" %>
<%@ page import="com.foodDelivaryApp.model.CartItem" %>
<%@ page import="com.foodDelivaryApp.servlets.UserServlet" %>
<%@ page import="com.foodDelivaryApp.model.Cart" %>
<%@ page import="javax.servlet.ServletException" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%
    Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
	Order order = (Order) request.getAttribute("order");
	User user = (User)session.getAttribute("user");
	
	System.out.print(isLoggedIn);
	System.out.print(user);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Now</title>
    <link rel="stylesheet" href="CSS/OrderNow.css" type="text/css">
</head>
<body>
<header> 
    		<div id="logo">Food<span id="logo-s">Go</span></div>
            <% String username = (String) session.getAttribute("username"); %>
            
            <% if (!(username==null) && !username.isEmpty()) { %>
               <div id="logo-1">Welcome  
               <a href="<%= request.getContextPath() %>/UserServlet?action=logout"><span id="logo-s-1"><%= username %></span></a></div>
            <% } else { %>
                <span class="sign"><a class="act" href="signUp.jsp">SIGN UP</a></span>
                <span class="sign"><a class="act" href="login.jsp">LOG IN</a></span>
            <% } %>
            <span class="sign"><a class="act" href="checkout.jsp">View Cart</a></span>
	</header>
<h1>Order Now</h1>

<form id="orderForm" action="<%= request.getContextPath() + "/orderConfirmationServlet" %>" method="POST">
	

    <input type="hidden" name="restaurantId" value="<%= order.getRestaurentid() %>">
    
    <div class="section">
        <h2 id="h2">Total Amount</h2>
        <p class="total-amount">Total Amount:  &#x20B9; <%= order.getTotalamount() %></p>
        <input type="hidden" id="amount" name="totalAmount" value=<%=order.getTotalamount() %>>
        
        
    </div>

    <div class="section">
        <h2>Delivery Address</h2>
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required>
    </div>

    <div class="section">
        <h2>Payment Method</h2>
        <label for="paymentMethod">Payment Method:</label>
        <select id="paymentMethod" name="paymentMethod" required>
            <option value="UPI">UPI</option>
            <option value="Cash">Cash</option>
            <option value="Debit Card">Debit Card</option>
            <option value="Credit Card">Credit Card</option>
        </select>
    </div>
    
	<div class="button-container">
    	<button onclick="proceedToOrder()"> Proceed to Order </button>
	</div>
    

</form>
<script>
    function proceedToOrder() {
        var url = '<%= isLoggedIn != null && isLoggedIn ? request.getContextPath() + "/orderConfirmationServlet" : request.getContextPath() + "/errorpage2.jsp" %>';
        window.location.href = url;
    }
</script>

</body>
</html>
