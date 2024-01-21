<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="CSS/loginstyle.css">
</head>
<body>
	<div class="container">
		<div class="form">
			<h1>Login</h1>
			<form class="input-group" id="input-form" action="UserServlet" method="post">
				<input type="hidden" name="action" value="login">
				<input type="text" class="input-field" placeholder="UserId" name = "username" required>
				<input type="password" class="input-field" placeholder="Enter Password" name="password" required>
				<button type="submit" class="submit-btn">Log In</button>
				<div class="display">
					<p>Don't have account?</p>
					<a href="signUp.jsp" name="anchor" value="Sign Up">Register</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>