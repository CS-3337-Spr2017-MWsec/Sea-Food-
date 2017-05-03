package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.CustomerBean;
import models.ProductBean;

//FOR REFERENCE.
//@WebServlet(name = "controllers/LoginController", urlPatterns = { "/controllers/LoginController" })
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean logout = request.getParameter("logout") != null;
		
		@SuppressWarnings("unchecked")
		ArrayList<CustomerBean> listOfCustomers = (ArrayList<CustomerBean>) getServletContext().getAttribute("listOfCustomers");
		
		if(logout){
			request.getSession().invalidate();
		}
		
		getServletContext().setAttribute("listOfCustomers", listOfCustomers);
		request.getRequestDispatcher("/WEB-INF/SFSS/Homepage.jsp").forward(request, response);
	}
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		ArrayList<CustomerBean> listOfCustomers = (ArrayList<CustomerBean>) getServletContext().getAttribute("listOfCustomers");
		CustomerBean customer = null;
		
		for(CustomerBean currCustomer: listOfCustomers){
			if(currCustomer.getUsername().equals(username) && currCustomer.getPassword().equals(password)){
				customer = currCustomer;
				
				listOfCustomers.add(customer);
				
				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("listOfCustomers", listOfCustomers);
//				request.getSession().setAttribute("userProducts", new ArrayList<ProductBean>());
				request.getServletContext().setAttribute("userProducts", new ArrayList<ProductBean>()); 
				
				response.sendRedirect("SeeFoodController");
				break;
			}
		}
		
		if(customer == null){
			doGet(request, response);
		}
	}
}