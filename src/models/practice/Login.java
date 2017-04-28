package models.practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.practice.Lab4User;

/**
 * Servlet implementation class Login
 */

@WebServlet(urlPatterns={"/Lab4/Login"}, loadOnStartup=1)
//@WebServlet(urlPatterns={""}, loadOnStartup=1)
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	Boolean loginFail = false;
    
	private String getUsername( HttpServletRequest request )
	    {
	        Cookie[] cookies = request.getCookies();
	        if( cookies != null )
	            for( Cookie cookie : cookies )
	                if( cookie.getName().equals( "username" ) )
	                    return cookie.getValue();
	        return "";
	    }

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
		 super.init(config);
		 
		 List<Lab4User> registeredUsers = new ArrayList<Lab4User>();

		 registeredUsers.add(new Lab4User("John Doe", "john","abcd"));
		 registeredUsers.add(new Lab4User("Mary Jane", "mary","abcd"));
		 registeredUsers.add(new Lab4User("Joe Boxer", "joe","abcd"));

		 getServletContext().setAttribute("registeredUsers", registeredUsers);
		 }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 
		 
		 	out.println( "<html>");
		 	out.println( "<head><title>Login</title></head>" );
	        out.println( "<body>" );

	        out.println( "<form action='Login' method='post'>" );
	       
	    if(loginFail == true)
	    	{
	    		out.println( "Incorrect username or password<br>");
	    	}
	     //  if(request.getParameter("username") != null || request.getParameter("password") != null)
	       
	     //  String username = getUsername(request);
	       
	    // if(username != null)
	    //	 out.println("Username: " + username + "<br>");
	   //  else
	    	 out.println( "Username: <input type='text' name='username' /> <br />" );
	       //out.println("username: <input type='text' name='username'" + username);
	       //out.println("<br><br>");
	       //out.println("<input name=\"username\" type=text value=""> + username
	        
	       // out.println( "Username: <input type='text' name='username' /> <br />" );
	        out.println( "Password: <input type='password' name='password' /> <br />" );
	        out.println( "Remember Me: <input type='checkbox' name='checkbox' /> <br />" );
	        out.println( "<input type='submit' name='login' value='Login' /> <br />" );
	        out.println( "</form>" );
	        
	 
	       
	       out.println("<a href='" + "../Homework2/Register" + "'>Register</a>");
	    
	       
	        out.println( "</body></html>" );			  
	}

	  @SuppressWarnings("unchecked")
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 PrintWriter out = response.getWriter();
		 
		 List<Lab4User> registeredUsers = (List<Lab4User>)getServletContext().getAttribute("registeredUsers");
		 
		 Boolean foundUser = false;
		
		//String username = getUsername(request);
		 String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("checkbox");
		
		
		
	/*	if(username == null)
		{
			username = request.getParameter("username");
			if(rememberMe != null)
			{
				Cookie cookie = new Cookie ("username", username);
				response.addCookie(cookie);
			}
		}*/
		
		for(int i=0; i<registeredUsers.size(); i++)
		{
			if(username.equals(registeredUsers.get(i).getUsername()) && password.equals(registeredUsers.get(i).getPassword()))
			{
				out.println("<h1>Welcome!</h1>");
				foundUser = true;
			}
		}
		
		if(foundUser == false)
		{
			loginFail = true;
			response.sendRedirect("Login");
		}
		
		
		
		/*Lab4User currentUser = null;
		
		for(Lab4User user : registeredUsers)
		{
			if(user.getUsername().equals(username) && user.getPassword().equals(password))
			{
				currentUser = user;
				request.getSession().setAttribute("currentUser", user);
				break;
			}
		}
		
		if(currentUser == null)
		{
			Cookie cookie = new Cookie("username", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			doGet(request,response);
			return;
		}*/
		
		if(rememberMe != null)
		{
			Cookie cookie = new Cookie ("username", username);
			response.addCookie(cookie);
		}
		
	}
}
		

