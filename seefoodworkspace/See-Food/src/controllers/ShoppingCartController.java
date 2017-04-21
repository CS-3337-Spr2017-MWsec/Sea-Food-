package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig; //TESTING ONLY.
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
		ArrayList<ProductBean> listOfProducts = (ArrayList<ProductBean>) getServletContext().getAttribute("listOfProducts");
			
		if(listOfProducts == null){
			request.getRequestDispatcher("/WEB-INF/SFSS/ShoppingCart.jsp").forward(request, response);
		}else{
			int numberOfProducts = 0;
			
			for(ProductBean products: listOfProducts){
				numberOfProducts++;
			}
			
			getServletContext().setAttribute("numberOfProducts", numberOfProducts);
			request.getServletContext().setAttribute("listOfProducts", listOfProducts);
			request.getRequestDispatcher("/WEB-INF/SFSS/ShoppingCart.jsp").forward(request, response);
		}
		
//		request.getRequestDispatcher("/WEB-INF/SFSS/ShoppingCart.jsp").forward(request, response);
	}
	
	//TODO Make userProducts be taken in by ShoppingCart.jsp.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ProductBean item = getProductBean(request, Integer.valueOf(request.getParameter("id")));
//		
		@SuppressWarnings("unchecked")
		ArrayList<ProductBean> listOfProducts = (ArrayList<ProductBean>) getServletContext().getAttribute("listOfProducts");
//		@SuppressWarnings("unchecked")
//		ArrayList<ProductBean> userProducts = (ArrayList<ProductBean>) getServletContext().getAttribute("userProducts");
		
//		for(ProductBean product: listOfProducts){
//			if(product.getId().equals(item)){
//				System.out.println("Found!");
//				userProducts.add(product);
//			}
//		}
		
//		userProducts.add(item);
//		
//		int numberOfProducts = 0;
//		
//		for(ProductBean products: listOfProducts){
//			numberOfProducts++;
//		}
//		
//		getServletContext().setAttribute("numberOfProducts", numberOfProducts);
		request.getServletContext().setAttribute("listOfProducts", listOfProducts);
		
//		request.getServletContext().setAttribute("userProducts", userProducts);
		
//		response.sendRedirect("ShoppingCartController");
		doGet(request, response);
	}
}