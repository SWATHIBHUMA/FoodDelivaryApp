<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ page import="java.util.Objects" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.io.IOException" %>
<%@ page import="com.foodDelivaryApp.model.Menu" %>
<%@ page import="com.foodDelivaryApp.model.User" %>
<%@ page import="com.foodDelivaryApp.model.CartItem" %>
<%@ page import="com.foodDelivaryApp.model.Cart" %>
<%@ page import="javax.servlet.ServletException" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="CSS/checkout.css" type="text/css">
</head>
<body>
    <h1 class="head">Your Cart Items</h1>
    	<%int restaurantId=0; %>
	    <div id="item-list">
	    		
	            <%
	            User user = (User)session.getAttribute("user");
	            Cart cart = (Cart)session.getAttribute("cart");	            
	            if (cart != null && !cart.getItems().isEmpty()) {%>
	            
	            
	                <%for (CartItem cartItem : cart.getItems().values()) {%>
	                <% 
			            if (restaurantId == 0) {
			                restaurantId = cartItem.getRestaurentId();
			            }
            		
	                System.out.println("resId in checkout: "+restaurantId);%>
		                    <div class="menu-item">
								<div class="item-details">
				                    <p><%= cartItem.getName() %></p>
				                    <p>Price: <%= cartItem.getPrice() %></p>
			                    </div>
			                    <div class="btn-inc-dec">
			                        
									<form action="cart" method="POST">
										<input type="hidden" name="itemId" value="<%= cartItem.getItemId() %>">
										<label>Quantity: <input type="number" name="qty" value="<%=cartItem.getQuantity() %>" min="1"></label>
										<input type="submit" name="action" value="update" class="dlt-btn">
									</form>

									
								</div>
							
			                    <div class="dlt-btn">
			                    	<form action="cart" method="POST">
				                    	<input type="hidden" name="action" value="delete">
				                    	<input type="hidden" name="itemId" value="<%= cartItem.getItemId() %>">
				                    	<button class="dlt-btn">Delete</button>
			                    	</form>
			                    </div>
		                    </div>

	            <%}%>

	            <%} else { %>
	                <p>No items in the cart</p>
	            <% } %>
	            
	           		<div class="btns">
					    <a href="Menus?restaurantId=<%= session.getAttribute("restaurentId") %>" class="add-more-btn">Add More Items</a>
					    <form id="orderForm" action="OrderServlet" method="POST" onsubmit="return calculateTotalAmount(event)">
						    <input type="hidden" id="totalAmountInput" name="totalAmount" value="0">
						    <button type="submit" class="proceed-btn">Proceed to order</button>
						    <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
						</form>


					</div>
	    	</div>


    <script>
    function calculateTotalAmount(event) {
        console.log("Js Executing");

        var quantityInputs = document.querySelectorAll('.btn-inc-dec input[name="qty"]');
        var itemDetails = document.querySelectorAll('.menu-item .item-details'); 

        var totalAmount = 0;

        for (var i = 0; i < quantityInputs.length; i++) {
            console.log("Entering loop iteration: " + i);

            var quantity = parseInt(quantityInputs[i].value);

            if (itemDetails[i]) {
                console.log("itemDetails[" + i + "] exists");

                var itemNameElement = itemDetails[i].querySelector('p:nth-child(1)');
                var priceElement = itemDetails[i].querySelector('p:nth-child(2)');

                if (itemNameElement && priceElement) {
                    console.log("itemNameElement and priceElement exist");

                    var itemName = itemNameElement.textContent.trim();
                    var priceText = priceElement.textContent.trim(); 
                    var price = parseFloat(priceText.split(":")[1].trim());
                    console.log("price: " + price);

                    totalAmount += quantity * price;
                } else {
                    console.log("itemNameElement or priceElement is null");
                }
            } else {
                console.log("itemDetails[" + i + "] is undefined");
            }
        }

        console.log("Total Amount: " + totalAmount);
        document.getElementById("totalAmountInput").value = totalAmount.toFixed(2);

    }


	</script>

</body>
</html>