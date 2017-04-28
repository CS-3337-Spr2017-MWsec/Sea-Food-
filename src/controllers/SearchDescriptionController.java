package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.ProductBean;


@WebServlet("/SearchDescriptionController")
public class SearchDescriptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<ProductBean> descriptionMatchProductList= (ArrayList<ProductBean>) request.getAttribute("descriptionMatchProductList");
		
		request.setAttribute("descriptionMatchProductList", descriptionMatchProductList);		
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/SFSS/ProductSelection.jsp");
		dispatcher.forward(request, response);		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//arraylist to hold products that match the user's query and are in stock
		ArrayList<ProductBean> descriptionMatchProductList = new ArrayList<ProductBean>();
		
		//flag to check condition of result for appropriate message to user
		boolean found = false;
		boolean stock = false;
		
		//store user's input
		String searchProductDescription = request.getParameter("searchProductDescription");
		
		boolean validSearchString = false;
				
		if(searchProductDescription != null && searchProductDescription.trim().length() > 0)
			validSearchString = true;

		if(validSearchString)
		{
	        Connection c = null;
	        try
	        {
	        	//database connection
	            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu92";
	            String username = "cs3220stu92";
	            String password = "lDpB8R.z";
	
	            c = DriverManager.getConnection( url, username, password );
	            Statement stmt = c.createStatement();
	
	     
	           //hold matching results from db query. 
	           ResultSet rs = stmt.executeQuery("SELECT * FROM `products` WHERE `description` LIKE '%"+searchProductDescription+"%'");
	
	           while( rs.next() )
	            {  
	        	   //at least one record has been found
	        	   found = true;
	            
	        	   //create prodcut object and intializing with results from db record 
	        	   ProductBean product = new ProductBean(rs.getInt("product_id"), rs.getString("name"), rs.getString("description"), 
	        			   rs.getInt("quantity"), rs.getDouble("price"), rs.getDouble("weight"), rs.getDouble("length"));
	        	   
	        	   //if the product has stock > 0, add to arraylist, for display back to user, and update stock flag to true
	        	   if(product.getStock() > 0)
	        	   {
	        		   descriptionMatchProductList.add(product);
	        		   stock = true;
	        	   }
	            }
	           
	           //close db connnection
	            c.close();
	        }
	        
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }
	        
	        finally
	        {
	            try
	            {
	                if( c != null ) c.close();
	            }
	            catch( SQLException e )
	            {
	                throw new ServletException( e );
	            }
	        }
		}

        //for products that exist but aren't in stock, display message to user
		if(found == true && stock == false)
			request.setAttribute("message2", "Looks like there aren't any products in stock with that contain: " + searchProductDescription);
		
		//for products in stock, display message to user
		else if(found == true && stock == true)
		{
			request.setAttribute("message2", "Here's what we found!");
			request.setAttribute("productCode2", "Product Code");
			request.setAttribute("productName2", "Name");
			request.setAttribute("productDescription2", "Description");
			request.setAttribute("productWeight2", "Weight");
			request.setAttribute("productLength2", "Length");
			request.setAttribute("productPrice2", "Price");
		}
		
		//if nothing was found matching user's query, display message
		else if(found == false)
		{
			request.setAttribute("message2", "We couldn't find anything with product description containing: " + searchProductDescription);
		}
		
		else if (!validSearchString)
			request.setAttribute("message2", "Please enter a valid search.");
			
		request.setAttribute("descriptionMatchProductList", descriptionMatchProductList);
		doGet(request, response);
	
	}

}

