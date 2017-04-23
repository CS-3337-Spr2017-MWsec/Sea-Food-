package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ProductBean;

@WebServlet("/ShoppingCartController")
public class ShoppingCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected ProductBean getProductBean(HttpServletRequest request, Integer id){
		@SuppressWarnings("unchecked")
		ArrayList<ProductBean> listOfProducts = (ArrayList<ProductBean>) getServletContext().getAttribute("listOfProducts");
		
		for(ProductBean product: listOfProducts){
			if(id.equals(product.getId())){
				return product;
			}
		}
		
		return null;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		ArrayList<ProductBean> userProducts = (ArrayList<ProductBean>) getServletContext().getAttribute("userProducts");

		if(request.getParameter("id") != null){			
			ProductBean item = getProductBean(request, Integer.valueOf(request.getParameter("id")));
			item.setQuantity(item.getQuantity() + 1);
			
			userProducts.add(item);
		}
		
		int numberOfProducts = 0;
		
		for(@SuppressWarnings("unused") ProductBean product: userProducts){
			numberOfProducts++;
		}
		
		request.getServletContext().setAttribute("numberOfProducts", numberOfProducts);
		request.getServletContext().setAttribute("userProducts", userProducts);
		request.getRequestDispatcher("/WEB-INF/SFSS/ShoppingCart.jsp").forward(request, response);
	}
	
	//TODO Make userProducts be taken in by ShoppingCart.jsp.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO Take in a form and send to RegistrationController to add added credentials.
		doGet(request, response);
	}
}