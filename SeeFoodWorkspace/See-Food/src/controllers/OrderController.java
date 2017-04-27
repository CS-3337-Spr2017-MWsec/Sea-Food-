package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.OrderBean;
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
		@SuppressWarnings("unchecked") //TODO Fix OrderBean and send to OrderConfirmation.jsp.
		ArrayList<OrderBean> productOrder = new ArrayList<OrderBean>();
		
		//TODO Test if these are actually required.
		Integer itemID = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
		String desc = request.getParameter("desc");
		Double weight = Double.valueOf(request.getParameter("weight"));
		Double length = Double.valueOf(request.getParameter("length"));
		Integer numOfItems = Integer.parseInt(request.getParameter("itemQuantity")); //User amount in ShoppingCart.jsp.
		
		for(ProductBean itemInCart: userProducts){
			if(itemID.equals(itemInCart.getId())){
				itemInCart.setQuantity(numOfItems);
			}
		}
		
		//TESTING.
		if(request.getParameter("username") == null){
			request.setAttribute("billing", null);
			response.sendRedirect("RegistrationController");
		}
		
		productOrder.add(new OrderBean(itemID, name, desc, weight, length, numOfItems, new Date()));
		
		request.getServletContext().setAttribute("userProducts", userProducts);
		request.getServletContext().setAttribute("productOrder", productOrder);
		doGet(request, response);
	}
}