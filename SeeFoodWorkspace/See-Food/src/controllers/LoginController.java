package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.CustomerBean;

//FOR REFERENCE.
//@WebServlet(name = "controllers/LoginController", urlPatterns = { "/controllers/LoginController" })
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean logout = request.getParameter("logout") != null;
		
		if(logout){
			request.getSession().invalidate();
		}
		
		request.getRequestDispatcher("/WEB-INF/SFSS/Homepage.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		@SuppressWarnings("unchecked")
		ArrayList<CustomerBean> listOfCustomers = (ArrayList<CustomerBean>) getServletContext().getAttribute("listOfCustomers");
		CustomerBean customer = null;
		
		for(CustomerBean currCustomer: listOfCustomers){
			if(currCustomer.getUsername().equals(username) && currCustomer.getPassword().equals(password)){
				customer = currCustomer;
				
				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("listOfCustomers", listOfCustomers);
				
				response.sendRedirect("SeeFoodController");
			}
		}
		
		if(customer == null){
			doGet(request, response);
		}
	}
}