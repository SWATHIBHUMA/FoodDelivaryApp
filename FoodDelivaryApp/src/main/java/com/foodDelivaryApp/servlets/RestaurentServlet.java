package com.foodDelivaryApp.servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodDelivaryApp.daoImpl.RestaurentDaoImpl;
import com.foodDelivaryApp.model.Restaurent;

@WebServlet("/Restaurents")
public class RestaurentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RestaurentDaoImpl res = new RestaurentDaoImpl();
		List<Restaurent> resItems = (List<Restaurent>) res.getAllRestaurent();
		
		System.out.println( "Restaurents List: " + resItems.size());
			
		request.setAttribute("resItem", resItems);
		
		RequestDispatcher rd = request.getRequestDispatcher("Restaurents.jsp");
		rd.include(request, response);
			
	}
}
