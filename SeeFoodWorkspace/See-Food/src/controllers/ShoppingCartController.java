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
		ArrayList<ProductBean> userProducts = (ArrayList<ProductBean>) request.getSession().getAttribute("userProducts");
		@SuppressWarnings("unchecked")
		ArrayList<ProductBean> listOfProducts = (ArrayList<ProductBean>) getServletContext().getAttribute("listOfProducts");
		
		//Changes items on homepage depending on user cart.
		ArrayList<ProductBean> newListOfProducts = new ArrayList<ProductBean>();
		
		//Checks to see if a guest user is trying to add to a cart.
		if(userProducts == null){
			request.getRequestDispatcher("/WEB-INF/SFSS/Error.jsp").forward(request, response);
		}else if(!request.getSession().getAttribute("username").equals(null) || request.getParameter("id") != null){
		
			//Adds to userProducts and removes from listOfProducts.
			ProductBean item = getProductBean(request, Integer.valueOf(request.getParameter("id")));
			
			userProducts.add(item);
			
			for(ProductBean product: listOfProducts){
				//If the item that the user chose to place in their cart is equal to the item
				// in the listOfProducts, do NOT add it.
				if(product.getId().equals(item.getId())){
					//Do nothing.
				}else{
					System.out.println("This ran from ShoppingCartController!");
					//Add to the new list of products available in stock.
					newListOfProducts.add(product);
				}
			}
		}
		
		int numberOfProducts = 0;
		
		if(userProducts != null){
			for(@SuppressWarnings("unused") ProductBean product: userProducts){
				numberOfProducts++;
			}
		}
		
		request.getSession().setAttribute("numberOfProducts", numberOfProducts);
		//OG.
//		request.getServletContext().setAttribute("userProducts", userProducts);
		request.getSession().setAttribute("userProducts", userProducts);
//		request.getSession().setAttribute("listOfProducts", newListOfProducts);
		request.getServletContext().setAttribute("listOfProducts", newListOfProducts);
		
		request.getRequestDispatcher("/WEB-INF/SFSS/ShoppingCart.jsp").forward(request, response);
	}
	
	//TODO Make userProducts be taken in by ShoppingCart.jsp.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO Take in a form and send to RegistrationController to add added credentials.
		doGet(request, response);
	}
}