package vendor.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ProductBean;


@WebServlet("/ViewAllDeleteController")
public class ViewAllDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewAllDeleteController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<ProductBean> viewAllProductsList = (ArrayList<ProductBean>) request.getAttribute("viewAllProductsList");

		request.setAttribute("viewAllProductsList",viewAllProductsList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/SFSS/DeleteProduct.jsp");
		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<ProductBean> viewAllProductsList = new ArrayList<ProductBean>();
		
		 Connection c = null;
	        try
	        {
	        	//database connection
	            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu92";
	            String username = "cs3220stu92";
	            String password = "lDpB8R.z";

	            c = DriverManager.getConnection( url, username, password );
	            Statement stmt = c.createStatement();

	          ResultSet rs = stmt.executeQuery("SELECT * FROM `products`");

	           while( rs.next() )
	            {  
	            
	        	   ProductBean product = new ProductBean(rs.getInt("product_id"), rs.getString("name"), rs.getString("description"), 
	        			   rs.getInt("quantity"), rs.getDouble("price"), rs.getDouble("weight"), rs.getDouble("length"));

	        	   viewAllProductsList.add(product);
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
	        
	        request.setAttribute("productCode", "Product Code");
			request.setAttribute("productName", "Name");
			request.setAttribute("productDescription", "Description");
			request.setAttribute("productWeight", "Weight");
			request.setAttribute("productLength", "Length");
			request.setAttribute("productPrice", "Price");

	    request.setAttribute("viewAllProductsList", viewAllProductsList);
	        
		doGet(request, response);
	}

}
