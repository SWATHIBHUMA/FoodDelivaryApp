<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.foodDelivaryApp.servlets.MenuServlet"%>	
<%@ page import="com.foodDelivaryApp.model.Menu"%>
<%@ page import="com.foodDelivaryApp.daoImpl.MenuDaoImpl"%>
<%@ page import="com.foodDelivaryApp.dao.MenuDao"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<link rel="stylesheet" href="CSS/menu.css" type="text/css">
</head>
<body>

	<header> 
    		<div id="logo">Food<span id="logo-s">BEE</span></div>
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

	<div class="menu-heading"><h1>Here goes menu ...</h1></div>
	
	<div id="notification"></div>

		<div class="list">

		<%
		try {
			@SuppressWarnings("unchecked")
			List<Menu> menuDao = (List<Menu>) request.getAttribute("menuItems");
			//out.println("Menu Items Size in jsp: " + (menuDao != null ? menuDao.size() : "null"));
			if (menuDao != null) {
		%>
		
				<%
				for (Menu menuItem : menuDao) {
				%>
					<div class="menu-card">
						<div class="menu-items">
							<p id="item-name">
								<strong><%=menuItem.getItemname()%></strong>
							</p>
							<p id="item-price">₹<%=menuItem.getPrice()%></p>
							<br>
							<p id="item-Description"><%=menuItem.getDescription()%></p>
							<br>
						</div>
						<div class="menu-image">
							<img src="<%=menuItem.getImagePath()%>" alt="Dosa Image" style="height: 125px; width:155px;"/>
							<input type="hidden" name="itemName" value="<%=menuItem.getItemname()%>">
    						<input type="hidden" name="itemPrice" value="<%=menuItem.getPrice()%>">
    						<form class = "btn-form" action="cart" method="POST">
    							<input type="hidden" name="resId" value="<%=menuItem.getRestaurentid()%>">
    							<input type="hidden" name="itemName" value="<%=menuItem.getItemname()%>">
    							<input type="hidden" name="itemPrice" value="<%=menuItem.getPrice()%>">
    							<input type="hidden" name="itemId" value="<%= menuItem.getMenuid() %>">
    							<input type="hidden" name="qty" value="1">
    							<input type="hidden" name="action" value="add">
								<button class="image-button">Add to Cart</button>
    						</form>
    						
						</div> 
					</div>
				<%
				}
				%> 
		</div>
				<%
				} else {
					
					out.println("Menu is not available.");
				}
			} catch (Exception e) {
				System.out.println("Hii");
				e.printStackTrace();
			}
			%>

	
		<!-- ... Your existing code ... -->
	<script>
	
		function addToCart(itemName, itemPrice) {
		    var cartItem = {
		        itemName: itemName,
		        itemPrice: itemPrice
		    };
		
		    var existingCart = JSON.parse(sessionStorage.getItem('cart')) || [];
		
		    existingCart.push(cartItem);
		
		    sessionStorage.setItem('cartItems', JSON.stringify(existingCart));
		    
		    var form = document.createElement('form');
		    form.action = '<%= request.getContextPath() %>/checkout';
		    form.method = 'post';

		   
		    var itemNameInput = document.createElement('input');
		    itemNameInput.type = 'hidden';
		    itemNameInput.name = 'itemName';
		    itemNameInput.value = itemName;

		    var itemPriceInput = document.createElement('input');
		    itemPriceInput.type = 'hidden';
		    itemPriceInput.name = 'itemPrice';
		    itemPriceInput.value = itemPrice;

		    form.appendChild(itemNameInput);
		    form.appendChild(itemPriceInput);

		    document.body.appendChild(form);

		    form.submit();

		    document.body.removeChild(form);

		    return false;
		}

</script>

	<script src="jsfile.js"></script>
</body>
</html>


		