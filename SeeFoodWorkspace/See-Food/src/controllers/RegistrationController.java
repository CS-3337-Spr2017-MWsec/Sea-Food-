package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.CustomerBean;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/SFSS/Registration.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		
		@SuppressWarnings("unchecked")
		ArrayList<CustomerBean> listOfCustomers = (ArrayList<CustomerBean>) getServletContext().getAttribute("listOfCustomers");
		
		boolean check = true;
		
		if(username.equals(null) || username.trim().length() == 0){
			check = false;
		}
		
		if(email.equals(null) || email.trim().length() == 0){
			check = false;
		}
		
		if(password1.equals(null) || password1.trim().length() == 0 || !password1.equals(password2)){
			check = false;
		}else if(password2.equals(null) || password2.trim().length() == 0 || !password2.equals(password1)){
			check = false;
		}
		
		if(check){
			listOfCustomers.add(new CustomerBean(username, email, password2));
			
			getServletContext().setAttribute("listOfCustomers", listOfCustomers);
			response.sendRedirect("SeeFoodController");
		}else{
			doGet(request, response);
		}
	}
}