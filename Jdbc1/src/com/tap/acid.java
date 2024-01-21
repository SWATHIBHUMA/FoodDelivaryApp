package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class acid {
	
	static final String sql = "UPDATE `employee` SET `salary` = `salary` + ? WHERE `id` = ?";
	static Connection con = null;
	static PreparedStatement pstmnt = null;
	static ResultSet res = null;
	static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/database1";
		String username = "root";
		String password = "root";
		try {
			con = DriverManager.getConnection(url, username,password);
			pstmnt = con.prepareStatement(sql);
			con.setAutoCommit(false);
			display(con, pstmnt, res);
			transaction();
			display(con, pstmnt, res);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public static void transaction() throws SQLException{
		
		System.out.println("Enter Senders Id");
		int senderId = sc.nextInt();
		System.out.println("Enter Receivers Id");
		int receiverId = sc.nextInt();
		System.out.println("Enter Amount");
		int amount = sc.nextInt();
		
		String SQL = "select * from `employee` where `id` = ?";
		pstmnt = con.prepareStatement(SQL);
		pstmnt.setInt(1, senderId);
		res = pstmnt.executeQuery();
		
		int i=0,j=0;
		if (res.next()) {
			if(!(amount>res.getInt("salary"))) {
				i= updateSalary(senderId, -amount);
				j = updateSalary(receiverId, amount);
			}
		} 
		
		
		if(confirmTransaction(i,j)){
			con.commit();
		}
		else {
			System.out.println("Rollbacked");
			con.rollback();
		}
	}
	
	public static int updateSalary(int user, int amount) throws SQLException{
		pstmnt = con.prepareStatement(sql);
		pstmnt.setInt(1, amount);
		pstmnt.setInt(2, user);
		
		int i = pstmnt.executeUpdate();
		return i;
	}
	
	public static boolean confirmTransaction(int i,int j) {
		System.out.println("Do you want to confirm transaction?(y/n)");
		String choice = sc.next();
		return choice.equalsIgnoreCase("y") && i==1 && j==1;
	}
	
	public static void display(Connection connection, PreparedStatement prestatement, ResultSet res) throws SQLException{
		String SQL = "select * from employee";
		prestatement = connection.prepareStatement(SQL);
		res = prestatement.executeQuery(SQL);
		System.out.println("Table:");
		System.out.println("+-----+-----------+----------------------+-------------+--------------+");
		while(res.next()) {
			
			System.out.printf("| %-3d | %-9s | %-20s | %-10s | %-13f |\n", res.getInt("id"),res.getString("ename"),
					res.getString("email"), res.getString("department"), res.getFloat("salary"));
		}
		System.out.println("+-----+-----------+----------------------+-------------+--------------+");
	}
}
