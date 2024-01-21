package com.foodDelivaryApp.servlets;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodDelivaryApp.model.Order;
import com.foodDelivaryApp.model.User;
import com.foodDelivaryApp.daoImpl.OrderItemDaoImpl;
import com.foodDelivaryApp.model.CartItem;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public OrderServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the total amount from the request
        double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));
        int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
        System.out.println("total amount: "+totalAmount);

        int tA = (int)totalAmount;
        
        Order order = new Order();

        order.setRestaurentid(restaurantId);
        order.setTotalamount(tA);


        request.setAttribute("order", order);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ordernow.jsp");
        dispatcher.forward(request, response);
        
        HttpSession session = request.getSession();
        CartItem cart = (CartItem)session.getAttribute("cart");
        
        
        
        
    }
}
