<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<link rel="stylesheet" href="CSS/loginstyle.css" type="text/css">
</head>
<body>
	<div class="container">
		<div class="form">
			<h1>Sign Up</h1>
			<form class="input-group" id="input-form" action="UserServlet" method="post">
				<input type="hidden" name="action" value="signup">
				<input type="text" class="input-field" placeholder="Enter UserName" name="username" required>
				<input type="email" class="input-field" placeholder="Enter Email" name="email" required> 
				<input type="password" class="input-field" placeholder="Enter Password" name="password" required>
				<button type="submit" class="submit-btn">Sign Up</button><br>
				<div class="display">
					<p>Already have account?</p>
					<a href="login.jsp" name="anchor" value="Login">Login</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>