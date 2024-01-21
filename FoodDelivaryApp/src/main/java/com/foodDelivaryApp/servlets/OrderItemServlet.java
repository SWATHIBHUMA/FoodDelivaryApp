package com.foodDelivaryApp.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodDelivaryApp.model.Menu;


@WebServlet("/OrderItemServlet")
public class OrderItemServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String resId = request.getParameter("resId");
		String itemName = request.getParameter("itemName");
        String itemPrice = request.getParameter("itemPrice");

        // Retrieve the existing list from the session or create a new one
        HttpSession session = request.getSession();
        List<Menu> cartItems = (List<Menu>) session.getAttribute("cartItems");
        
        if (cartItems == null) {
            cartItems = new ArrayList<>();
        }

        Menu cartItem = new Menu(0, Integer.parseInt(resId), itemName, null, Double.parseDouble(itemPrice), false,0.0, null);
        cartItems.add(cartItem);


        session.setAttribute("cartItems", cartItems);

        response.sendRedirect(request.getContextPath() + "/checkout.jsp");

	}	
}	