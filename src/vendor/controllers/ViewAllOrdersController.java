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

import models.VendorOrderBean;
import models.VendorOrderBean;
import models.CustomerBean;


@WebServlet("/ViewAllOrdersController")
public class ViewAllOrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewAllOrdersController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<VendorOrderBean> viewAllOrdersList = (ArrayList<VendorOrderBean>) request.getAttribute("viewAllOrdersList");
		//ArrayList<CustomerBean> viewAllOrdersCustomerList =(ArrayList<CustomerBean>) request.getAttribute("viewAllOrdersCustomerList");
		
		request.setAttribute("viewAllOrdersList",viewAllOrdersList);
		//request.setAttribute("viewAllOrdersCustomerList",viewAllOrdersCustomerList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/SFSS/OrderManagement.jsp");
		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<VendorOrderBean> viewAllOrdersList = new ArrayList<VendorOrderBean>();
		//ArrayList<CustomerBean> viewAllOrdersCustomerList = new ArrayList<CustomerBean>();
		
		 Connection c = null;
	        try
	        {
	        	//database connection
	            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu92";
	            String username = "cs3220stu92";
	            String password = "lDpB8R.z";

	            c = DriverManager.getConnection( url, username, password );
	            Statement stmt = c.createStatement();

	         //ResultSet rs = stmt.executeQuery("SELECT * FROM `Orders`");
	         //   ResultSet rs = stmt.executeQuery( 
	           // 		"SELECT `Orders.order_id`, `Customers.first_name`, `Customers.last_name`, `Customers.address`, `Customers.city`, `Customers.zip`, `Customers.state`,`Customers.email` "
	         //   		+ "FROM Orders "
	         //   		+ "INNER JOIN Customers ON Orders.customer_id = Customers.customer_id");
	            
	         ResultSet rs = stmt.executeQuery("SELECT * FROM `Orders` INNER JOIN Customers ON Orders.customer_id = Customers.customer_id");
	           while( rs.next() )
	            {  
	            
	        	   //VendorOrderBean order = new VendorOrderBean(rs.getInt("order_id"), rs.getInt("customer_id"));
	        	   VendorOrderBean order = new VendorOrderBean(rs.getInt("order_id"), rs.getInt("customer_id"), rs.getString("first_name"),rs.getString("last_name"));
	        	   
	        	 //  CustomerBean customer = new CustomerBean(rs.getString("first_name"));

	        	   viewAllOrdersList.add(order);
	        	  // viewAllOrdersCustomerList.add(customer);
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
	        
	        //jsp table headers
	    
			request.setAttribute("orderId", "Order Id");
			request.setAttribute("customerId", "Customer Id");
			request.setAttribute("firstName", "First Name");
			request.setAttribute("lastName", "Last Name");
			
			
		//request.setAttribute("viewAllOrdersCustomerList", viewAllOrdersCustomerList);
	    request.setAttribute("viewAllOrdersList", viewAllOrdersList);
	        
		doGet(request, response);
	}

}
