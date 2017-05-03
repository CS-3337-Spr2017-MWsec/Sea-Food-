package vendor.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.CustomerBean;
import models.ProductBean;
import models.VendorOrderBean;

@WebServlet("/OrderDetailsController")
public class OrderDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init( ServletConfig config ) throws ServletException{
    	
    	 /*super.init( config );

         try
         {
             Class.forName( "com.mysql.jdbc.Driver" );
         }
         catch( ClassNotFoundException e )
         {
             throw new ServletException( e );
         }*/

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int orderId = Integer.parseInt(request.getParameter("id"));
		
		ArrayList<CustomerBean> viewCustomerList = new ArrayList<CustomerBean>();
		ArrayList<ProductBean> orderDetailsProductList = new ArrayList<ProductBean>();
		
		Connection c = null;
        try
        {
        	//database connection
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu92";
            String username = "cs3220stu92";
            String password = "lDpB8R.z";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            
           //   ResultSet rs = stmt.executeQuery("SELECT * FROM `products` WHERE `product_id`='"+editProductSearch+"'"); 
          ResultSet rs = stmt.executeQuery("SELECT * FROM `Orders` "
          		+ "INNER JOIN Customers ON Orders.customer_id = Customers.customer_id "
          		+ "WHERE order_id = '"+orderId+"'");
          
            
	        while( rs.next() )
	        {  
	        	CustomerBean customer = new CustomerBean(rs.getString("first_name"), rs.getString("last_name"),rs.getString("shipping_street_address"), 
	        			   rs.getString("shipping_city"),rs.getString("shipping_state"), rs.getInt("shipping_zip"), rs.getString("billing_street_address"), 
	        			   rs.getString("billing_city"),rs.getString("billing_state"), rs.getInt("billing_zip"), rs.getString("email"), rs.getString("telephone"));

	        	 viewCustomerList.add(customer);

	         }
	        
	        		rs = stmt.executeQuery("SELECT * FROM `OrderDetails` "
	    		   //rs = stmt.executeQuery("SELECT FROM OrderDetails.order_id, OrderDetails.quantity, products.product_id, products.name, products,price "
	          		+ "INNER JOIN products ON OrderDetails.product_id = products.product_id "
	          		+ "WHERE order_id = '"+orderId+"'");

	        		
	       while( rs.next() )
	        {  
	    	   ProductBean product = new ProductBean(rs.getInt("product_id"), rs.getString("name"), rs.getString("description"), 
        			   rs.getInt("quantity_ordered"), rs.getDouble("price"), rs.getDouble("weight"), rs.getDouble("length"));

	    	   orderDetailsProductList.add(product);

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
		
		request.setAttribute("orderId", orderId);
		
		request.setAttribute("firstName", "First Name");
		request.setAttribute("lastName", "Last Name");
		request.setAttribute("shippingStreetAddress", "Shipping Street Address");
		request.setAttribute("shippingCity", "Shipping City");
		request.setAttribute("shippingState", "Shipping State");
		request.setAttribute("shippingZip", "Shipping Zip Code");
		request.setAttribute("email", "Email");
		request.setAttribute("phoneNumber", "Phone Number");
		
		request.setAttribute("productId", "Product Code");
		request.setAttribute("productName", "Product Name");
		request.setAttribute("productDescription", "Product Description");
		request.setAttribute("price", "  Price  ");
		request.setAttribute("weight", "Weight");
		request.setAttribute("length", "Length");
		request.setAttribute("quantity", "Qty");
	
		request.setAttribute("viewCustomerList", viewCustomerList);
		request.setAttribute("orderDetailsProductList", orderDetailsProductList);

		
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/SFSS/OrderDetails.jsp");
		dispatcher.forward(request, response);	
	}

}
