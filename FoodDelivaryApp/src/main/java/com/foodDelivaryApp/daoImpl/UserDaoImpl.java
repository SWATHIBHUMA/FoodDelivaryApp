package com.foodDelivaryApp.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.foodDelivaryApp.dao.UserDao;
import com.foodDelivaryApp.model.User;

public class UserDaoImpl implements UserDao {
	
	static PreparedStatement preparedStatement;
	static Statement statement;
	static ResultSet res;

	private static final String ADD_USER_QUERY = "INSERT INTO user (Username, Password, Email, Address, Role) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_USER_QUERY = "SELECT * FROM user WHERE UserID = ?";
    private static final String UPDATE_USER_QUERY = "UPDATE user SET Username=?, Password=?, Email=?, Address=?, Role=? WHERE UserID=?";
    private static final String DELETE_USER_QUERY = "DELETE FROM user WHERE UserID=?";
    private static final String GET_ALL_USERS_QUERY = "SELECT * FROM user";
    private static final String USER_EXISTS_QUERY = "SELECT COUNT(*) FROM user WHERE Username = ? OR Email = ?";
    
	@Override
	public void addUser(User user) {
		
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement= connection.prepareStatement(ADD_USER_QUERY);
			
			preparedStatement.setString(1, user.getUsername());
	        preparedStatement.setString(2, user.getPassword());
	        preparedStatement.setString(3, user.getEmail());
	        preparedStatement.setString(4, user.getAddress());
	        preparedStatement.setString(5, user.getRole());

	        preparedStatement.executeUpdate();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUser(int userId) {
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(GET_USER_QUERY);
			res = preparedStatement.executeQuery();
			
			if(res.next()) {
				int userid = res.getInt("UserID");
				String username = res.getString("Username");
				String password = res.getString("Password");
				String email = res.getString("Email");
				String address = res.getString("Address");
				String role = res.getString("Role");
				
				return new User(userid,username,password,email,address,role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateUser(User user) {
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(UPDATE_USER_QUERY);
			
			preparedStatement.setString(1, user.getUsername());
	        preparedStatement.setString(2, user.getPassword());
	        preparedStatement.setString(3, user.getEmail());
	        preparedStatement.setString(4, user.getAddress());
	        preparedStatement.setString(5, user.getRole());
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int userId) {
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(DELETE_USER_QUERY);
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getAllUsers() {
		
		List<User> userlist = new ArrayList<>();

		try {
			Connection connection = Connector.requestConnection();
			statement = connection.createStatement();
			
			res = statement.executeQuery(GET_ALL_USERS_QUERY);

			while (res.next()) {
				
				int userid = res.getInt("UserID");
				String username = res.getString("Username");
				String password = res.getString("Password");
				String email = res.getString("Email");
				String address = res.getString("Address");
				String role = res.getString("Role");

				User user = new User(userid,username,password,email,address,role);
				userlist.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userlist;
	}

	@Override
	public boolean UserExists(String username, String password) {
		return false;
	}
}
