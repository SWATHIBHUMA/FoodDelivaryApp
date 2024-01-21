<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error - Nothing in Cart</title>
    <link rel="stylesheet" href="CSS/ErrorStyle.css" type="text/css">
</head>
<body>
    <div class="container">
        <h1>Oops!</h1>
        <p class="text">It seems like your cart is empty. Add items to the cart or explore restaurants.</p>
        <button onclick="window.location.href='<%= request.getContextPath() %>/Restaurents'">Explore Restaurants</button>
    </div>
</body>
</html>
