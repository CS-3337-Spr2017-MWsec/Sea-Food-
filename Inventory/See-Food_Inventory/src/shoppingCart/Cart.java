package shoppingCart;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class Cart {
	int id;
	String name;
	double price;
	int quantity;

	public Cart(int id, String name, double price, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public static void viewCart(ArrayList<Cart> products) {
		System.out.println("ID\tName\tPrice\tQuantity\n");
		double total =0;
		for (int j=0; j< products.size(); j++ ) {
			total+= products.get(j).getPrice();
		}
	
		
		for (int i = 0; i < products.size(); i++) {
			double value = products.get(i).getPrice();
			System.out.print(products.get(i).getId() + "\t");
			System.out.print(products.get(i).getName() + "\t");
			System.out.printf("%.2f", value); // price
			System.out.print("\t" + products.get(i).getQuantity());
			System.out.print("\n");

		}
		//total = Math.round(total *100)/100;
		DecimalFormat format = new DecimalFormat("#.##");
		total = Double.valueOf(format.format(total));
		System.out.println("Total cost: "+ total  + " " );
		System.out.println("Enter product id to edit or 0 to exit ");
	}

	public static void editCart(int id, int selection, ArrayList<Cart> products) {
		selection = checkDigit();
		int quantity =0;
		double price =0;
 		if (selection == 1) {
 			int originalQ = products.get(id).getQuantity();
 			double originalP= products.get(id).getPrice();
 			price = originalP/originalQ;
 			double total =0;
			System.out.println("Enter quantity for " + products.get(id).getName());
			quantity= checkDigit();
			total = price *quantity;
			Cart edit = new Cart(products.get(id).getId(), products.get(id).getName(), total, quantity);
			products.set(id, edit);
		} else if (selection == 2) {
			System.out.println(products.get(id).getName() + " has been removed");
			products.remove(id);
		
		}

	}

	public static int checkDigit() {
		String id;
		Scanner scanner = new Scanner(System.in);
		int number = 0;

		int counter = 0;

		id = scanner.nextLine();

		int length = id.length();
		boolean exit = true;
		while (exit != false) {

			// if (Character.isDigit(id.charAt(counter))&& length!=0)
			if (length == 0 || !Character.isDigit(id.charAt(counter))) {
				System.out.println("Enter a valid Number");
				id = scanner.nextLine();
				counter = 0;
				length = id.length();
			} else if (length - 1 <= counter) {
				exit = false;
			} else {
				counter++;
			}
		}
	//	scanner.close();
		number = Integer.parseInt(id);
		return number;
	}

	public static int validID(int id, ArrayList<Cart> products) {
		boolean exit = true;
		int counter = 0;
		//id = checkDigit();
		while (exit == true) {// if there are 2 missing ids, finds the
			// System.out.println("id"+products.indexOf(id));
			if (counter == products.size() || id > products.get(products.size() - 1).getId()) {
				System.out.println("Invalid ID..");
				id = checkDigit();
				counter = 0;
			} else if (id != products.get(counter).getId()) {
				counter++;
			} else {
				id = counter;
				exit = false;

			}
		}
		return id;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int id = 4;
		int index =0;
		ArrayList<Cart> products = new ArrayList<Cart>();
		Cart product = new Cart(1, "fish", 3.060, 3);
		Cart product1 = new Cart(3, "catfish", 4.060, 2);
		Cart product2 = new Cart(5, "salmon", 8.00, 4);
		products.add(product);
		products.add(product1);
		products.add(product2);
		int selection = 0;
		while (id!=0) {
			Collections.sort(products, new Comparator<Cart>() { // sorts
				public int compare(Cart a, Cart b) {
					return Integer.valueOf(a.id).compareTo(b.id);
				}
			});
			viewCart(products);
			id = checkDigit(); //checks number
			index = validID(id, products);	//checks valid id and grabs the index
			System.out.println("Editing for " + products.get(index).getName());
			System.out.println("Enter 1 to edit quantity or 2 to remove ");
			editCart(index, selection, products);

		}

	}

}
