package com.foodDelivaryApp.servlets;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodDelivaryApp.daoImpl.MenuDaoImpl;
import com.foodDelivaryApp.model.Menu;

@WebServlet("/Menus")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MenuDaoImpl menu = new MenuDaoImpl();
		
		String restaurantIdParam = request.getParameter("restaurantId");
	    
	    if (restaurantIdParam == null || "null".equalsIgnoreCase(restaurantIdParam.trim())) {
	        response.sendRedirect(request.getContextPath() + "/errorPage.jsp");
	        return;
	    }
		
		int restaurantId = Integer.parseInt(restaurantIdParam);
		
		System.out.println(restaurantId);
		try {
			List<Menu> menuItems = (ArrayList<Menu>) menu.getAllMenusByRestaurent(restaurantId);
			
			request.setAttribute("menuItems", menuItems);
			
			System.out.println("size of menu items: " + menuItems.size());
//			for(Menu menus1:menuItems) {
//				System.out.println(menus1.getDescription());
//				System.out.println(menus1.getItemname());
//				System.out.println(menus1.getMenuid());
//				System.out.println(menus1.getPrice());
//				System.out.println(menus1.getRestaurentid());
//			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Menus.jsp");
		    dispatcher.forward(request, response);
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
}
