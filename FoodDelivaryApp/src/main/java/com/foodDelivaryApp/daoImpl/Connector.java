package com.foodDelivaryApp.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	
	public static Connection connection;
	public static String url="jdbc:mysql://localhost:3306/fooddelivaryapp";
	public static String username = "root";
	public static String password = "root";
	
	public static Connection requestConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(url,username,password);
		return connection;
	}
}
