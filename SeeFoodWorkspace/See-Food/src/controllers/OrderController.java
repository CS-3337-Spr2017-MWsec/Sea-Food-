package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ProductBean;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/SFSS/OrderConfirmation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TEST.
		@SuppressWarnings("unchecked")
		ArrayList<ProductBean> userProducts = (ArrayList<ProductBean>) getServletContext().getAttribute("userProducts");
		
		//TODO Test if these are actually required.
		Integer itemID = Integer.valueOf(request.getParameter("id"));
		Integer numOfItems = Integer.parseInt(request.getParameter("itemQuantity")); //User amount in ShoppingCart.jsp.
		String desc = request.getParameter("desc");
		
		for(ProductBean itemInCart: userProducts){
			if(itemID.equals(itemInCart.getId())){
				itemInCart.setQuantity(numOfItems);
			}
		}
		
		//TESTING.
		if(request.getParameter("username") == null){
			request.setAttribute("billing", true);
			response.sendRedirect("RegistrationController");
		}
		
		doGet(request, response);
	}
}