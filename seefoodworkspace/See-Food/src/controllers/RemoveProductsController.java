package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ProductBean;

@WebServlet("/RemoveProductsController")
public class RemoveProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO Finish doGet and doPost.
		@SuppressWarnings("unchecked")
		ArrayList<ProductBean> oldList = (ArrayList<ProductBean>) getServletContext().getAttribute("listOfProducts");
		ArrayList<ProductBean> newList = new ArrayList<ProductBean>();
		
		for(ProductBean product: oldList){
			if(!product.isDelete()){
				newList.add(product);
			}
		}
		
		request.getSession().setAttribute("listOfProducts", newList);
		response.sendRedirect("ShoppingCartController");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}