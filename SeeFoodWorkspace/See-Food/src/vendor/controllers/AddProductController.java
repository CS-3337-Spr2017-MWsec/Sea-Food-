package vendor.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ProductBean;

@WebServlet("/AddProductController")
public class AddProductController extends HttpServlet {
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/SFSS/AddProduct.jsp");
		dispatcher.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String productName = request.getParameter("productCode");
		String productName = request.getParameter("productName");
		String productDescription= request.getParameter("productDescription");
		String productPrice = request.getParameter("productPrice");
		String productWeight= request.getParameter("productWeight");
		String productLength = request.getParameter("productLength");
		
		Boolean success = false;
		
		Connection c = null;
        try
        {
        	//database connection
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu92";
            String username = "cs3220stu92";
            String password = "lDpB8R.z";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
		
            int i = stmt.executeUpdate("insert into products(name, description, price, weight, length) "
            		+ "values('"+productName+"','"+productDescription+"','"+productPrice+"','"+productWeight+"','"+productLength+"')");
            
            if(i > 0)
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
        	request.setAttribute("message", "The new product has been successfully added");
        else
        	request.setAttribute("message", "The was an error adding the new product.");

		doGet(request, response);
	}

}
