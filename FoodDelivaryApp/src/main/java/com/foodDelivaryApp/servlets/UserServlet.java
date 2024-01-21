package com.foodDelivaryApp.servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodDelivaryApp.Utilities.AESPasswordHashing;
import com.foodDelivaryApp.daoImpl.UserDaoImpl;
import com.foodDelivaryApp.model.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public UserServlet() {
        super();
    }
    UserDaoImpl userDao = new UserDaoImpl();
    
    public void init() throws ServletException {
        super.init();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if ("logout".equals(action)) {
            handleLogout(request, response);
        } 
		else {
			System.out.println("Huff");
		}
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		String action = request.getParameter("action");

        if ("login".equals(action)) {
            handleLogin(request, response);
        } else if ("signup".equals(action)) {
            handleSignUp(request, response);
        }
	}
	
	private void handleLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect("Restaurents");
		
	}
	
	private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");

	    if (username != null && password != null) {
	        User user = getUserByUsernameAndPassword(username, password);

	        if (user != null) {
	            HttpSession session = request.getSession();
	            session.setAttribute("username", username); 
	            session.setAttribute("user", user); 
	            session.setAttribute("isLoggedIn", true);
	            
	            System.out.println("User set in session: " + user.getUsername() + " (" + user.getUserId() + ")");
	            
	            response.sendRedirect("Restaurents");
	        } else {
	            response.sendRedirect("login.jsp?error=wrongData");
	        }
	    }
	}

	private User getUserByUsernameAndPassword(String username, String enteredPassword) {
	    List<User> userList = userDao.getAllUsers();
	    for (User user : userList) {
	        if (username.equals(user.getUsername()) && AESPasswordHashing.verifyPassword(user.getPassword(), enteredPassword,"randomSalting")) {
	            return user;
	        }
	    }
	    return null;
	}
	//private static final String SECRET_KEY = System.getenv("MY_APP_SECRET_KEY");

	private void handleSignUp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        User user = new User();
        
        if (username != null && email != null && password != null) {
            if (isEmailAlreadyResgistered(email)) {
                response.sendRedirect("login.jsp?message=Email already registered");
            } else {
            	
            	user.setUsername(username);
            	String encryptedPassword = AESPasswordHashing.hashPassword(password,"randomSalting");
    			user.setPassword(encryptedPassword);
    			user.setEmail(email);
    			user.setRole("Customer");

    			userDao.addUser(user);
                response.sendRedirect("login.jsp");
            }
        }
	}

	public boolean isEmailAlreadyResgistered(String email) {
		List<User> userlist = userDao.getAllUsers();
		for(User users : userlist) {
			if(email.equals(users.getEmail())) {
				System.out.println(users.getEmail());
				return true;
			}
		}
		return false;
	}
	
	private boolean isPasswordCorrect(String username, String enteredPassword) {
		System.out.println("heyy passwoed loop");
		List<User> userlist = userDao.getAllUsers();
        for(User users : userlist) {
        	if(enteredPassword.equals(users.getPassword())) {
        		return true;
        	}
        }
        return false;
    }

}
