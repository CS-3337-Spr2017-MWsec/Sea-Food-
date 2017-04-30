package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ProductBean;

@WebServlet("/ToggleRemoveController")
public class ToggleRemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected ProductBean getProductBean(HttpServletRequest request, Integer id){
		@SuppressWarnings("unchecked")
//		ArrayList<ProductBean> listOfProducts = (ArrayList<ProductBean>) getServletContext().getAttribute("listOfProducts");
		ArrayList<ProductBean> userProducts = (ArrayList<ProductBean>) request.getSession().getAttribute("userProducts");
		
		for(ProductBean product: userProducts){
			if(id.equals(product.getId())){
				System.out.println("This ran from ToggleRemoveController!");
				return product;
			}
		}
		
		return null;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductBean product = getProductBean(request, Integer.valueOf(request.getParameter("id")));
		
		if(product != null){
			product.setDelete(!product.isDelete());
		}
		
		response.sendRedirect("ShoppingCartController");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}