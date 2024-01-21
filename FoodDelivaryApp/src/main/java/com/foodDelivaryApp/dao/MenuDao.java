package com.foodDelivaryApp.dao;

import java.util.List;

import com.foodDelivaryApp.model.Menu;

public interface MenuDao {
	void addMenu(Menu menu);
	Menu getMenu(int menuId);
	void updateMenu(Menu menu);
	void deleteMenu(int menuId);
	List<Menu> getAllMenusByRestaurent(int restaurentId);
}