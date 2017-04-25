package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ProductBean;


@WebServlet("/ProductSelectionController")
public class ProductSelectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String isNull = null;
	
	public void init( ServletConfig config ) throws ServletException{
        super.init( config );

        //Create some test data for display.
        ArrayList<ProductBean> listOfTestProducts = new ArrayList<ProductBean>();
        
        listOfTestProducts.add(new ProductBean("Cape Lobster", 
				"The Cape lobster, Homarinus capensis, is a species of small lobster\n "
				+ "that lives off the coast of South Africa, from Dassen Island to\n "
				+ "Haga Haga. Only a few dozen specimens are known, mostly regurgitated\n "
				+ "by reef-dwelling fish.", 50, 19.99, 6, 1));
        listOfTestProducts.add(new ProductBean("Homarus Lobster",
				"Homarus is a genus of lobsters, which include the common and commercially\n "
				+ "significant species Homarus americanus and Homarus gammarus. The Cape\n "
				+ "lobster, which was formerly in this genus as H. capensis, was moved in\n "
				+ "1995 to the new genus Homarinus.", 89, 15.66, 8, 1.2));
        
        for(ProductBean item: listOfTestProducts){
        	System.out.println(item.getId());
        	System.out.println(item.getName());
        }
        
        //Store the data somewhere that can be accessed by this servlet.
        getServletContext().setAttribute("listOfTestProducts", listOfTestProducts);
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			@SuppressWarnings("unchecked")
//			ArrayList<ProductBean> listOfTestProducts = (ArrayList<ProductBean>) getServletContext().getAttribute("listOfTestProducts");
			@SuppressWarnings("unchecked")
			ArrayList<ProductBean> filteredListOfTestProducts = (ArrayList<ProductBean>) getServletContext().getAttribute("filteredListOfTestProducts");
	
//			if(filteredListOfTestProducts != null){
			if(filteredListOfTestProducts != null && isNull != null){
				request.getServletContext().setAttribute("isNull", isNull);
				request.getServletContext().setAttribute("filteredListOfTestProducts", filteredListOfTestProducts);				
//			}else{
//				request.getServletContext().setAttribute("listOfTestProducts", listOfTestProducts);	
			}
		
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/SFSS/ProductSelection.jsp");
//			dispatcher.forward(request, response);
				
			request.setAttribute("productCode", "Product Code");
			request.setAttribute("productName", "Name");
			request.setAttribute("productDescription", "Description");
			request.setAttribute("productWeight", "Weight");
			request.setAttribute("productLength", "Length");
			request.setAttribute("productPrice", "Price");	
			
			request.getRequestDispatcher("/WEB-INF/SFSS/ProductSelection.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		isNull = null;
		
		String s = request.getParameter("searchProductCode");
		
		@SuppressWarnings("unchecked")
		ArrayList<ProductBean> listOfTestProducts = (ArrayList<ProductBean>) getServletContext().getAttribute("listOfTestProducts");

		//Contains all products that match the search query.
		ArrayList<ProductBean> filteredListOfTestProducts = new ArrayList<ProductBean>();

		if(s.equals(null) || s.trim().length() == 0){
			String errorMsg = "Please input a number.";
			request.setAttribute("errorMsg", errorMsg);
		}else{
		
			int searchProductCode= Integer.parseInt(s);
			
			
			boolean found = false;
			boolean stock = false;
			
	
			//Search all all products for matching search query from input.
			for(ProductBean product: listOfTestProducts){
				//If match found, add to filtered list.
				if(product.getId() == searchProductCode){
					found = true;
					
					if(product.getStock() > 0){
						stock = true;
						System.out.println("This ran!");
						System.out.println(product.getName());
						filteredListOfTestProducts.add(product);
					}
				}
			}
			
			if(found == false){
				request.setAttribute("message", "We couldn't find anything with that product code.");
				
			}else if(found == true && stock == true){
				request.setAttribute("message", "We found something!");
				request.setAttribute("productCode", "Product Code");
				request.setAttribute("productName", "Name");
				request.setAttribute("productDescription", "Description");
				request.setAttribute("productWeight", "Weight");
				request.setAttribute("productLength", "Length");
				request.setAttribute("productPrice", "Price");
				
				isNull = "x";
				
			}else if(found == true && stock == false){
				request.setAttribute("message", "Looks like that product has already been sold.");
			}
		}
		
		request.getServletContext().setAttribute("filteredListOfTestProducts", filteredListOfTestProducts);
		doGet(request, response);
	}
}