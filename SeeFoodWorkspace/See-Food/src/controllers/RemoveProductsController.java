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
//		@SuppressWarnings("unchecked")
//		ArrayList<ProductBean> listOfProducts = (ArrayList<ProductBean>) getServletContext().getAttribute("listOfProducts");
		@SuppressWarnings("unchecked")
		ArrayList<ProductBean> oldList = (ArrayList<ProductBean>) request.getSession().getAttribute("userProducts");
		ArrayList<ProductBean> newList = new ArrayList<ProductBean>();
		
		for(ProductBean product: oldList){
			if(!product.isDelete()){
				System.out.println("This ran from RemoveProductsController.");
				//Keep the products that are NOT marked for deletion.
				newList.add(product);
				//Restock the item back in the homepage.
//				listOfProducts.add(product);
			}
		}

		request.getSession().setAttribute("userProducts", newList);
//		request.getServletContext().setAttribute("listOfProducts", listOfProducts);
		response.sendRedirect("ShoppingCartController");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}