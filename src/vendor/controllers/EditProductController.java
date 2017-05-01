package vendor.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import models.ProductBean;

@WebServlet("/EditProductController")
public class EditProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init( ServletConfig config ) throws ServletException{
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
		
		ArrayList<ProductBean> editProductList = (ArrayList<ProductBean>) request.getAttribute("editProductList");

		request.setAttribute("editProductList", editProductList);		

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/SFSS/EditProduct.jsp");
		dispatcher.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
		//contains all products that match the search query
		ArrayList<ProductBean> editProductList= new ArrayList<ProductBean>();
		
		
		int editProductSearch;
		boolean found = false;

		String input = request.getParameter("editProductSearch");
		if(input == null || input == "")
		{
			input ="0";
		}
		
		if(Pattern.matches("[a-zA-Z]+", input) == true && input.length() >= 1)
		{
			input ="0";
		}
		
		editProductSearch= Integer.parseInt(input);

        Connection c = null;
        try
        {
        	//database connection
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu92";
            String username = "cs3220stu92";
            String password = "lDpB8R.z";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();

 
          //need to add prepared statement
          ResultSet rs = stmt.executeQuery("SELECT * FROM `products` WHERE `product_id`='"+editProductSearch+"'");

           while( rs.next() )
            {  
        	   found = true;
            
        	   ProductBean product = new ProductBean(rs.getInt("product_id"), rs.getString("name"), rs.getString("description"), 
        			   rs.getInt("quantity"), rs.getDouble("price"), rs.getDouble("weight"), rs.getDouble("length"));

        	   editProductList.add(product);
            }
           
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

		
		if(input == "0")
			request.setAttribute("message", "Please enter a valid product code");
		
		else if(found == true && input !="0")
		{
			request.setAttribute("productCode", "Product Code");
			request.setAttribute("productName", "Name");
			request.setAttribute("productDescription", "Description");
			request.setAttribute("productWeight", "Weight");
			request.setAttribute("productLength", "Length");
			request.setAttribute("productPrice", "Price");
		}
		
		else if(found == false && input  !="0")
		{
			request.setAttribute("message", "We couldn't find anything with Product Code " + editProductSearch);
		}
		
		 
		request.setAttribute("editProductList", editProductList);
		doGet(request, response);
	}

}
