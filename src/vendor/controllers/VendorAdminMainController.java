
package vendor.controllers;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VendorAdminMainController")
public class VendorAdminMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init( ServletConfig config ) throws ServletException{
    	
    	super.init( config 
    	);

         try
         {
             Class.forName( "com.mysql.jdbc.Driver" );
         }
         catch( ClassNotFoundException e )
         {
             throw new ServletException( e );
         }

    }

    public VendorAdminMainController() {
        super();
  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher( "/WEB-INF/SFSS/VendorAdmin.jsp" ).forward(request, response );

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
