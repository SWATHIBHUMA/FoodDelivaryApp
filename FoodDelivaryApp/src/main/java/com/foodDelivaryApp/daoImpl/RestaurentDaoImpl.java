package com.foodDelivaryApp.daoImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodDelivaryApp.dao.RestaurentDao;
import com.foodDelivaryApp.model.Restaurent;

public class RestaurentDaoImpl implements RestaurentDao{
	
	static PreparedStatement preparedStatement;
	static Statement statement;
	static ResultSet res;
	
	private static final String ADD_RESTAURANT_QUERY = "INSERT INTO restaurant (Name, Address, Rating, CuisineType, IsActive, ETA, AdminUserID, ImagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_RESTAURANT_QUERY = "SELECT * FROM restaurant WHERE RestaurantID = ?";
    private static final String UPDATE_RESTAURANT_QUERY = "UPDATE restaurant SET Name=?, Address=?, Rating=?, CuisineType=?, IsActive=?, ETA=?, AdminUserID=?, ImagePath=? WHERE RestaurantID=?";
    private static final String DELETE_RESTAURANT_QUERY = "DELETE FROM restaurant WHERE RestaurantID=?";
    private static final String GET_ALL_RESTAURANTS_QUERY = "SELECT * FROM restaurant";
	
	@Override
	public void addRestaurent(Restaurent restaurent) {
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement= connection.prepareStatement(ADD_RESTAURANT_QUERY);
			
			preparedStatement.setString(1, restaurent.getName());
            preparedStatement.setString(2, restaurent.getAddress());
            preparedStatement.setFloat(3, restaurent.getRating());
            preparedStatement.setString(4, restaurent.getCuisinetype());
            preparedStatement.setBoolean(5, restaurent.getIsactive());
            preparedStatement.setInt(6, restaurent.getEta());
            preparedStatement.setInt(7, restaurent.getAdminuserid());
            preparedStatement.setString(8, restaurent.getImagePath());
            
            preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Restaurent getRestaurent(int restaurentId) {
		
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(GET_RESTAURANT_QUERY);
			res = preparedStatement.executeQuery();
			
			if(res.next()) {
				int restaurentid = res.getInt("RestaurantID");
				String name = res.getString("Name");
				String address = res.getString("Address");
				float rating = res.getFloat("Rating");
				String cuisinetype = res.getString("CuisineType");
				boolean isactive = res.getBoolean("IsActive");
				int eta = res.getInt("ETA");
				int adminuserid = res.getInt("AdminUserID");
				String imagePath = res.getString("ImagePath");
				
				return new Restaurent(restaurentid,name,address,rating,cuisinetype,isactive,eta,adminuserid,imagePath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateRestaurent(Restaurent restaurent) {
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(UPDATE_RESTAURANT_QUERY);
			preparedStatement.setInt(1, restaurent.getRestaurentid());
			preparedStatement.setString(2, restaurent.getName());
            preparedStatement.setString(3, restaurent.getAddress());
            preparedStatement.setFloat(4, restaurent.getRating());
            preparedStatement.setString(5, restaurent.getCuisinetype());
            preparedStatement.setBoolean(6, restaurent.getIsactive());
            preparedStatement.setInt(7, restaurent.getEta());
            preparedStatement.setInt(8, restaurent.getAdminuserid());
            preparedStatement.setString(9, restaurent.getImagePath());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRestaurent(int restaurentId) {
		
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(DELETE_RESTAURANT_QUERY);
			
			preparedStatement.setInt(1, restaurentId);
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Restaurent> getAllRestaurent() {
		
		List<Restaurent> restaurentlist = new ArrayList<Restaurent>();

		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(GET_ALL_RESTAURANTS_QUERY);
			
			res = preparedStatement.executeQuery();

			while (res.next()) {
				
				int restaurentid = res.getInt("RestaurantID");
				String name = res.getString("Name");
				String address = res.getString("Address");
				float rating = res.getFloat("Rating");
				String cuisinetype = res.getString("CuisineType");
				boolean isactive = res.getBoolean("IsActive");
				int eta = res.getInt("ETA");
				int adminuserid = res.getInt("AdminUserID");
				String imagePath = res.getString("ImagePath");
				System.out.println(restaurentid);
				
				Restaurent restaurent = new Restaurent(restaurentid, name, address, rating, cuisinetype, isactive, eta, adminuserid, imagePath);
				restaurentlist.add(restaurent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restaurentlist;
	}
}
