package com.foodDelivaryApp.dao;


import java.util.List;

import com.foodDelivaryApp.model.Restaurent;

public interface RestaurentDao {
	void addRestaurent(Restaurent restaurent);
	Restaurent getRestaurent(int restaurentId);
	void updateRestaurent(Restaurent restaurent);
	void deleteRestaurent(int restaurentId);
	List<Restaurent> getAllRestaurent();
}
