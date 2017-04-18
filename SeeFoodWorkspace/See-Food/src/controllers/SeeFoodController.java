package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.CustomerBean;

@WebServlet("/SeeFoodController")
public class SeeFoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		ArrayList<CustomerBean> listOfCustomers = new ArrayList<CustomerBean>();
		
		listOfCustomers.add(new CustomerBean("admin", "admin@fake.com", "abcd"));
		listOfCustomers.add(new CustomerBean("admin2", "admin2@real.com", "1234"));
		
		getServletContext().setAttribute("listOfCustomers", listOfCustomers);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		ArrayList<CustomerBean> listOfCustomers = (ArrayList<CustomerBean>) getServletContext().getAttribute("listOfCustomers");
		
		if(listOfCustomers == null){
			request.getRequestDispatcher("/WEB-INF/SFSS/Homepage.jsp").forward(request, response);
		}else{
			request.setAttribute("listOfCustomers", listOfCustomers);
			request.getRequestDispatcher("/WEB-INF/SFSS/Homepage.jsp").forward(request, response);			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}