package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet1 extends HttpServlet{
	
	static Connection connection;
	static PreparedStatement stmnt;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {  
			e.printStackTrace();
		}
		
		int id = Integer.parseInt(req.getParameter("number"));
		String name = req.getParameter("username");
		String email = req.getParameter("uemail");
		String department = req.getParameter("dept");
		int salary = Integer.parseInt(req.getParameter("sal"));
		
		
		PrintWriter out = resp.getWriter();
		out.print("<h1>");
		out.print("Hello "+ name +" Welcome to servlet page ");
		out.print("</h1>");
		
		out.print("<table border=1px solid black>");
		out.print("<tr>");
		out.print("<th>");
		out.print("<h3>ID: " +  id + "</h3>");
		out.print("</th>");
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<th>");
		out.print("<h3>Name:" +  name + "</h3>");
		out.print("</th>");
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<th>");
		out.print("<h3>Email:" +  email + "</h3>");
		out.print("</th>");
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<th>");
		out.print("<h3>Department:" +  department + "</h3>");
		out.print("</th>");	
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<th>");
		out.print("<h3>Salary:" +  salary + "</h3>");
		out.print("</th>");		
		out.print("</tr>");
		
		out.print("</table>");
		
		try{
			
			String url = "jdbc:mysql://localhost:3306/database1";
			String username = "root";
			String password = "root";
			
			connection = DriverManager.getConnection(url, username, password);
			String sql = "INSERT INTO employee (`id`,`ename`,`email`,`department`,`salary`) VALUES (?,?,?,?,?)";
			stmnt = connection.prepareStatement(sql);
			
			stmnt.setInt(1, id);
			stmnt.setString(2, name);
			stmnt.setString(3, email);
			stmnt.setString(4, department);
			stmnt.setInt(5, salary);
			stmnt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Thank You...!!!");
		}
	}
}
