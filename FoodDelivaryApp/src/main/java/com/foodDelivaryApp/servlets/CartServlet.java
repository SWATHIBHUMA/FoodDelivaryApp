package com.foodDelivaryApp.servlets;

import com.foodDelivaryApp.daoImpl.MenuDaoImpl;
import com.foodDelivaryApp.model.Cart;
import com.foodDelivaryApp.model.CartItem;
import com.foodDelivaryApp.model.Menu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CartServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String operation = request.getParameter("action");

        if (operation.equals("update")) {
            updateCartItems(request,cart);
        }
//        else if(operation.equals("decrement")) {
//        	updateCartItems(request,cart,-1);
//        	
//        }
        else if (operation.equals("delete")) {
            deleteCartItems(request,cart);
        }
        else if (operation.equals("add")) {
        	System.out.println("addItemToCart");
            addItemToCart(request,cart);
        }

        session.setAttribute("cart", cart);
        System.out.println("session");
        response.sendRedirect("checkout.jsp");
    }
    
    
    

    private void updateCartItems(HttpServletRequest request, Cart cart)
            throws ServletException, IOException {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int quantity= Integer.parseInt(request.getParameter("qty"));
        cart.updateItem(itemId, quantity);
    }


	private void deleteCartItems(HttpServletRequest request, Cart cart) {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		cart.removeItem(itemId);
		
	}

	private void addItemToCart(HttpServletRequest request, Cart cart) {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		int quantity= Integer.parseInt(request.getParameter("qty"));
		
		MenuDaoImpl menuDao = new MenuDaoImpl();
		Menu menuItem = menuDao.getMenu(itemId);
		
		HttpSession session = request.getSession();
		session.setAttribute("restaurentId", menuItem.getRestaurentid());
		
		if(menuItem!=null) {
			CartItem item = new CartItem(menuItem.getMenuid(), menuItem.getRestaurentid(),menuItem.getItemname(),quantity,menuItem.getPrice());
			cart.addItem(item);
		}
	}
}