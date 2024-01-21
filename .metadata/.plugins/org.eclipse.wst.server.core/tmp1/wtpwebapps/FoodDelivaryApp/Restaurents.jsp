<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.foodDelivaryApp.model.Restaurent" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurent</title>
<link rel="stylesheet" href="CSS/restaurent.css" type="text/css">
</head>
<body>
	<header> 
    		<div id="logo">Food<span id="logo-s">BEE</span></div>
            <% String username = (String) session.getAttribute("username"); %>
            <% if (!(username==null) && !username.isEmpty()) { %>
               <div id="logo-1">Welcome  
               <a href="<%= request.getContextPath() %>/UserServlet?action=logout"><span id="logo-s-1"><%= username %></span></a></div>
               <span class="sign"><a class="act" href="checkout.jsp">View Cart</a></span>
            <% } else { %>
                <span class="sign"><a class="act" href="signUp.jsp">SIGN UP</a></span>
                <span class="sign"><a class="act" href="login.jsp">LOG IN</a></span>
            <% } %>
	</header>
	<div class="slider">
		<div class="myslide fade">
			<div class="txt">
				<h1>Indian</h1>
				<p>Explore Variety of Indian dishes...</p>
			</div>
			<img src="images/pexels-chan-walrus-958545.jpg" style="width: 100%; height: 100%;" id="img1">
		</div>

		<div class="myslide fade">
			<div class="txt">
				<h1>Cuisine</h1>
				<p>Explore international cuisines...</p> 
			</div>
			<img src="images/fresh-gourmet-meal-beef-taco-salad-plate-generated-by-ai.jpg" style="width: 100%; height: 100%;" id="img1">
		</div>

		<div class="myslide fade">
			<div class="txt">
				<h1>Burgers</h1>
				<p>Explore variety of burgers...</p>
			</div>
			<img src="images/pexels-rajesh-tp-1600727.jpg" alt="Restaurant Image" style="width: 100%; height: 100%;" id="img1">
		</div>
		<a class="prev" onclick="plusSlides(-1)">&#10094;</a> <a class="next"
		
			onclick="plusSlides(1)">&#10095;</a>

		<div class="dotsbox" style="text-align: center">
			<span class="dot" onclick="currentSlide(1)"></span> <span class="dot"
				onclick="currentSlide(2)"></span> <span class="dot"
				onclick="currentSlide(3)"></span>
		</div>
	</div>

	<div class="rest">
		<h1>Explore the restaurents here...</h1>
	</div>

	<!--Cards-Container-->
	<div class="container">
	<%
		List<Restaurent> resItem = (List<Restaurent>)request.getAttribute("resItem");
		if (resItem == null) {
	    	out.println("No Restuarents Available Right Now");
	    	System.out.println("resItems is null");     
		} 
		else {
			for(Restaurent res : resItem){
	%>
			<div class="card" id="restaurant1">
				<a href="Menus?restaurantId=<%= res.getRestaurentid()%>">
					<img class= "card-image" src=<%=res.getImagePath() %> alt="Restaurant Image">
					<div class="card-content">
						<h4><%= res.getName() %> <span>&#x2B50; <%= res.getRating() %></span></h4>
						<p>Cuisine: <%= res.getCuisinetype() %></p>
						<p>&#x1F4CD;<%= res.getAddress() %></p>
					</div>
				 </a>
			</div> 
		<%
			}}
		%>
		</div>
	<script src="JS/restaurent.js"></script>
	<footer>
		<hr>
		<h3 id="footer">@Food BEE Copyrights - 2024. All Rights Reserved</h3>
	</footer>
</body>
</html>