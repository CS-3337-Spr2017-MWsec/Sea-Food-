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

@WebServlet("/EditProductButtonController")
public class EditProductButtonController extends HttpServlet {
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
		
		ArrayList<ProductBean> editProductList= new ArrayList<ProductBean>();
		
		int editProductCode = Integer.parseInt(request.getParameter("id"));
		
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
          ResultSet rs = stmt.executeQuery("SELECT * FROM `products` WHERE `product_id`='"+editProductCode+"'");

           while( rs.next() )
            {  
            
        	   ProductBean product = new ProductBean(rs.getInt("product_id"), rs.getString("name"), rs.getString("description"), 
        			   rs.getInt("quantity"), rs.getDouble("price"), rs.getDouble("weight"), rs.getDouble("length"));
        	   
        	   request.setAttribute("productCode", product.getId());
        	   request.setAttribute("productName", product.getName());
        	   request.setAttribute("productDescription", product.getDescription());
        	   request.setAttribute("productQuantity", product.getQuantity());
        	   request.setAttribute("productPrice", product.getPrice());
        	   request.setAttribute("productWeight", product.getWeight());
        	   request.setAttribute("productLength", product.getLength());

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
        
        doPost(request, response);
   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/SFSS/UpdateProduct.jsp");
		dispatcher.forward(request, response);	
		
	
	}

}
