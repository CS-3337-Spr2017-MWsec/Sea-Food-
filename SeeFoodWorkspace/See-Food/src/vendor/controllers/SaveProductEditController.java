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

@WebServlet("/SaveProductEditController")
public class SaveProductEditController extends HttpServlet {
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
		
		String productName = request.getParameter("productName");
		String productDescription= request.getParameter("productDescription");
		double price = Double.parseDouble(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		double weight = Double.parseDouble(request.getParameter("weight"));
		double length = Double.parseDouble(request.getParameter("length"));
		
		int editProductCode = Integer.parseInt(request.getParameter("id"));

		Connection c = null;
		
		boolean success = false;
		
        try
        {
        	//database connection
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu92";
            String username = "cs3220stu92";
            String password = "lDpB8R.z";

            c = DriverManager.getConnection( url, username, password );
           // Statement stmt = c.createStatement();
            
            //ResultSet rs = stmt.executeQuery("UPDATE `products` SET `name` WHERE `product_id`='"+editProductCode+"'");

            PreparedStatement st = c.prepareStatement("Update `products` SET `name`=?, `description`=?, `quantity`=?, `price`=?, "
            		+ "`weight`=?, `length`=? WHERE `product_id` = ?");
            st.setString(1,productName);
            st.setString(2,productDescription);
            st.setInt(3,quantity);
            st.setDouble(4,price);
            st.setDouble(5,weight);
            st.setDouble(6,length);
            st.setInt(7,editProductCode);
            st.executeUpdate();
            
            success = true;

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
        
        if(success == true)
        	request.setAttribute("messageEdit", "The product has been edited.");
        else
        	request.setAttribute("messageEdit", "There was an error editing the product.");
        
        doPost(request, response);
   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/SFSS/EditProduct.jsp");
		dispatcher.forward(request, response);	

	}

}
