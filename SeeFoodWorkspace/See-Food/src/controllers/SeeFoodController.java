package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.CustomerBean;
import models.ProductBean;

@WebServlet("/SeeFoodController")
public class SeeFoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//Initialize admin and admin2 with higher permissions.
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		//listOfCustomers.
		ArrayList<CustomerBean> listOfCustomers = new ArrayList<CustomerBean>();
		
		listOfCustomers.add(new CustomerBean("admin", "admin@fake.com", "abcd"));
		listOfCustomers.add(new CustomerBean("admin2", "admin2@real.com", "1234"));
		
		
		
		//listOfProducts.
		ArrayList<ProductBean> listOfProducts = new ArrayList<ProductBean>();
		
		//LOBSTERS.
		listOfProducts.add(new ProductBean("Cape Lobster", 
				"The Cape lobster, Homarinus capensis, is a species of small lobster\n "
				+ "that lives off the coast of South Africa, from Dassen Island to\n "
				+ "Haga Haga. Only a few dozen specimens are known, mostly regurgitated\n "
				+ "by reef-dwelling fish.", 1, 19.99, 6, 1));
		listOfProducts.add(new ProductBean("Homarus Lobster",
				"Homarus is a genus of lobsters, which include the common and commercially\n "
				+ "significant species Homarus americanus and Homarus gammarus. The Cape\n "
				+ "lobster, which was formerly in this genus as H. capensis, was moved in\n "
				+ "1995 to the new genus Homarinus.", 1, 15.66, 8, 1.2));
		listOfProducts.add(new ProductBean("Norway Lobster",
				"Nephrops norvegicus, known variously as the Norway lobster, Dublin Bay prawn,\n"
				+ "langoustine or scampi, is a slim, orange-pink lobster which grows up to 25 cm\n"
				+ "long, and is \"the most important commercial crustacean in Europe\".", 72, 16.89, 8.5, 0.9));
		
		//OYSTERS.
		listOfProducts.add(new ProductBean("Akoya Pearl Oyster",
				"Pinctada fucata, the Akoya pearl oyster, is a species of marine bivalve mollusk in\n"
				+ "the family Pteriidae, the pearl oysters. Some authorities classify this oyster as\n"
				+ "Pinctada imbricata fucata.", 1, 11.00, 3.3, 0.29));
		listOfProducts.add(new ProductBean("Pacific Oyster",
				"The Pacific oyster, Japanese oyster or Miyagi oyster, is an oyster native to the\n"
				+ "Pacific coast of Asia. It has become an introduced species in North America, Australia,\n"
				+ "Europe, and New Zealand.", 1, 13.59, 3.76, 0.25));
		listOfProducts.add(new ProductBean("Ostrea Edulis",
				"Ostrea edulis is a species of oyster native to Europe and commonly known as the European\n"
				+ "flat oyster, Colchester native oyster, mud oyster, or edible oyster. The fossil record of\n"
				+ "this species dates back to the Miocene.", 1, 14.26, 3.6, 0.23));
		
		//SALMONS.
		listOfProducts.add(new ProductBean("Atlantic Salmon",
				"The Atlantic salmon is a species of ray-finned fish in the family Salmonidae. It is found in\n"
				+ "the northern Atlantic Ocean, in rivers that flow into the north Atlantic and, due to human\n"
				+ "introduction, in the north Pacific Ocean.", 1, 9.23, 10.66, 14.7));
		listOfProducts.add(new ProductBean("Chinook Salmon",
				"The Chinook salmon is the largest species in the Pacific salmon genus Oncorhynchus. The common\n"
				+ "name refers to the Chinookan peoples. Other vernacular names for the species include king salmon,\n"
				+ "Quinnat salmon, spring salmon, and Tyee salmon.", 1, 10.99, 16.1, 13));
		

		getServletContext().setAttribute("billing", null); //TESTING: No billing address as of yet.
		
		getServletContext().setAttribute("listOfProducts", listOfProducts);
		//OG.
//		getServletContext().setAttribute("userProducts", new ArrayList<ProductBean>());
		
		getServletContext().setAttribute("listOfCustomers", listOfCustomers);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		ArrayList<CustomerBean> listOfCustomers = (ArrayList<CustomerBean>) getServletContext().getAttribute("listOfCustomers");
		
		request.setAttribute("listOfCustomers", listOfCustomers);
		request.getRequestDispatcher("/WEB-INF/SFSS/Homepage.jsp").forward(request, response);			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}