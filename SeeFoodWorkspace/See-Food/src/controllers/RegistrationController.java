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

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/SFSS/Registration.jsp").forward(request, response);
	}
	
	protected void goBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/SFSS/Registration.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getAttribute("billing") != null){
			@SuppressWarnings("unchecked")
			ArrayList<CustomerBean> listOfCustomers = (ArrayList<CustomerBean>) getServletContext().getAttribute("listOfCustomers");
			
			String username = (String) getServletContext().getAttribute("username");
			
			if(username.equals(null) || username.trim().length() == 0){
				request.getRequestDispatcher("/WEB-INF/SFSS/Registration.jsp").forward(request, response);
			}else{
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String shippingAddress = request.getParameter("shippingAddress");
				String number = request.getParameter("number");
				String billingAddress = request.getParameter("billingAddress");
				Integer card = Integer.valueOf(request.getParameter("card"));
				
				if(firstName.equals(null) || firstName.trim().length() == 0){
					goBack(request, response);
				}else{
					if(lastName.equals(null) || lastName.trim().length() == 0){
						goBack(request, response);
					}else{
						if(shippingAddress.equals(null) || shippingAddress.trim().length() == 0){
							goBack(request, response);
						}else{
							if(number.equals(null) || number.trim().length() == 0){
								goBack(request, response);
							}else{
								if(billingAddress.equals(null) || billingAddress.trim().length() == 0){
									goBack(request, response);
								}else{
									if(card.equals(null) || card.toString().trim().length() == 0){
										goBack(request, response);
									}else{
										for(CustomerBean customer: listOfCustomers){
											if(username.equals(customer.getUsername())){
												request.getRequestDispatcher("/WEB-INF/SFSS/OrderConfirmation.jsp").forward(request, response);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}else{
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String password1 = request.getParameter("password1");
			String password2 = request.getParameter("password2");
			
			@SuppressWarnings("unchecked")
			ArrayList<CustomerBean> listOfCustomers = (ArrayList<CustomerBean>) getServletContext().getAttribute("listOfCustomers");
//			@SuppressWarnings("unchecked")
//			ArrayList<ProductBean> userProducts = (ArrayList<ProductBean>) getServletContext().getAttribute("userProducts");
			
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
				
//				request.getServletContext().setAttribute("noBilling", null); //TESTING.
				request.getServletContext().setAttribute("listOfCustomers", listOfCustomers);
//				request.getServletContext().setAttribute("userProducts", new ArrayList<ProductBean>());
				request.getSession().setAttribute("userProducts", new ArrayList<ProductBean>());
				response.sendRedirect("SeeFoodController");
			}else{
				doGet(request, response);
			}
		}
	}
}