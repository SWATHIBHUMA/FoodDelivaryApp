package com.foodDelivaryApp.daoImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodDelivaryApp.dao.MenuDao;
import com.foodDelivaryApp.model.Menu;

public class MenuDaoImpl implements MenuDao{
	
	static PreparedStatement preparedStatement;
	static Statement statement;
	static ResultSet res;
	
	private static final String ADD_MENU_QUERY = "INSERT INTO menu (RestaurantID, ItemName, Description, Price, IsAvailable, Ratings, ImagePath) VALUES (?,?, ?, ?, ?, ?, ?)";
    private static final String GET_MENU_QUERY = "SELECT * FROM menu WHERE MenuID = ?";
    private static final String UPDATE_MENU_QUERY = "UPDATE menu SET RestaurantID=?, ItemName=?, Description=?, Price=?, IsAvailable=?, Ratings=? ,ImagePath=? WHERE MenuID=?";
    private static final String DELETE_MENU_QUERY = "DELETE FROM menu WHERE MenuID=?";
    private static final String GET_ALL_MENUS_BY_RESTAURANT_QUERY = "SELECT * FROM menu WHERE RestaurantID=?";

    
	@Override
	public void addMenu(Menu menu) {
		
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement= connection.prepareStatement(ADD_MENU_QUERY);
			
			preparedStatement.setInt(1, menu.getRestaurentid());
            preparedStatement.setString(2, menu.getItemname());
            preparedStatement.setString(3, menu.getDescription());
            preparedStatement.setDouble(4, menu.getPrice());
            preparedStatement.setBoolean(5, menu.isAvailable());
            preparedStatement.setDouble(6, menu.getRatings());
            preparedStatement.setString(7, menu.getImagePath());

	        preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Menu getMenu(int menuId) {
		
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(GET_MENU_QUERY);
			preparedStatement.setInt(1, menuId);
			res = preparedStatement.executeQuery();
			
			if(res.next()) {
				int menuid = res.getInt("MenuID");
				int restaurentid = res.getInt("RestaurantID");
				String itemname = res.getString("ItemName");
				String description = res.getString("Description");
				double price = res.getDouble("Price");
				boolean isavailable = res.getBoolean("IsAvailable");
				double ratings = res.getDouble("Ratings");
				String imagePath = res.getString("ImagePath");
				
				return new Menu(menuid,restaurentid,itemname,description,price,isavailable,ratings,imagePath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void updateMenu(Menu menu) {
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(UPDATE_MENU_QUERY);
			
			preparedStatement.setInt(1, menu.getMenuid());
			preparedStatement.setInt(2, menu.getRestaurentid());
            preparedStatement.setString(3, menu.getItemname());
            preparedStatement.setString(4, menu.getDescription());
            preparedStatement.setDouble(5, menu.getPrice());
            preparedStatement.setBoolean(6, menu.isAvailable());
            preparedStatement.setDouble(6, menu.getRatings());
            preparedStatement.setString(6, menu.getImagePath());
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMenu(int menuId) {
		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(DELETE_MENU_QUERY);
			preparedStatement.setInt(1, menuId);
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Menu> getAllMenusByRestaurent(int restaurentId) {
		ArrayList<Menu> menulist = new ArrayList<>();

		try {
			Connection connection = Connector.requestConnection();
			preparedStatement = connection.prepareStatement(GET_ALL_MENUS_BY_RESTAURANT_QUERY);
			preparedStatement.setInt(1, restaurentId);
			
			res = preparedStatement.executeQuery();

			while (res.next()) {
				
				int menuid = res.getInt("MenuID");
				int restaurentid = res.getInt("RestaurantID");
				String itemname = res.getString("ItemName");
				String description = res.getString("Description");
				double price = res.getDouble("Price");
				boolean isavailable = res.getBoolean("IsAvailable");
				double ratings = res.getDouble("Ratings");
				String imagePath = res.getString("ImagePath");
				
				Menu menus = new Menu(menuid,restaurentid,itemname,description,price,isavailable,ratings,imagePath);
				menulist.add(menus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menulist;
	}

}
