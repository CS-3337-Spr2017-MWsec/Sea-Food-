package vendor;

import java.util.*;
import java.util.regex.Pattern;

public class Test {
	int id;
	String name;
	double price;

	public Test(int id, String name, double price) {

		this.id = id;
		this.name = name;
		this.price = price;

		// System.out.println("in constructor");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		// System.out.println("in getName");
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

	/*
	 * public ProductAdd(int id, String name, double price) { super(id, name,
	 * price);
	 * 
	 * }
	 */

	public static void addProduct(int id, String name, double price, ArrayList<Test> products) {
		Test newProduct = new Test(id, name, price);
		products.add(newProduct);

		System.out.println("New product has been added\n");

		System.out.println("ID\tName\tPrice\n");

		for (int i = 0; i < products.size(); i++) {
			double value = products.get(i).getPrice();
			System.out.print(products.get(i).getId() + "\t");
			System.out.print(products.get(i).getName() + "\t");
			// System.out.print(products.get(i).getPrice() + "\t" + "\n");
			System.out.printf("%.2f", value);
			System.out.print("\t\n");
		}
	}

	public static void editProduct(int id, String name, double price, ArrayList<Test> products) {
		Test edit = new Test(id, name, price);
		products.set(id - 1, edit);

		System.out.println("Product has been edited\n");

		System.out.println("ID\tName\tPrice\n");
		for (int i = 0; i < products.size(); i++) {
			double value = products.get(i).getPrice();
			System.out.print(products.get(i).getId() + "\t");
			System.out.print(products.get(i).getName() + "\t");
			// System.out.print(products.get(i).getPrice() + "\t" + "\n");
			System.out.printf("%.2f", value);
			System.out.print("\t\n");
		}

	}

	public static void deleteProduct(int id, ArrayList<Test> products) {
		products.remove(id - 1);
		System.out.println("Product has been removed");
		System.out.println("ID\tName\tPrice\n");
		for (int i = 0; i < products.size(); i++) {
			System.out.print(products.get(i).getId() + "\t");
			System.out.print(products.get(i).getName() + "\t");
			System.out.print(products.get(i).getPrice() + "\t" + "\n");
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

		number = Integer.parseInt(id);
		return number;
	}

	public static double checkDouble() {
		String price;
		Scanner scanner = new Scanner(System.in);
		double number = 0;

		int counter = 0;
		final String regExp = "[0-9]+([,.][0-9]{1,2})?";
		final Pattern pattern = Pattern.compile(regExp);
		System.out.println("enter a price");
		price = scanner.nextLine();

		int length = price.length();
		boolean exit = true;
		while (exit != false) {

			// if (Character.isDigit(id.charAt(counter))&& length!=0)
		

			if (price.matches(regExp) == false || length == 0) {

				System.out.println("Enter a valid number");
				price = scanner.nextLine();
				counter = 0;
				length = price.length();
			} else if (length - 1 <= counter) {
				exit = false;
			} else {
				counter++;
			}
		}
		number =Double.parseDouble(price);
	
		return number;
	}

	public static String checkName() {
		String name;

		Scanner scanner = new Scanner(System.in);

		int counter = 0;

		System.out.println("enter Product Name");
		name = scanner.nextLine();

		int length = name.length();
		boolean exit = true;
		while (exit != false) {

			// if (Character.isDigit(id.charAt(counter))&& length!=0)
			if (length == 0 || !Character.isLetter(name.charAt(counter))) {
				System.out.println("Enter a valid Name");
				name = scanner.nextLine();
				counter = 0;
				length = name.length();
			} else if (length - 1 <= counter) {
				exit = false;
			} else {
				counter++;
			}
		}

		return name;

	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int option = 0;
		int id;
		String name;
		Double price;

		ArrayList<Test> products = new ArrayList<Test>();
		// products.add(new Product (1, "red lobster", 20.00));

		Test newProduct = new Test(1, "lobster", 20.69);
		products.add(newProduct);

		// option = Integer.parseInt(scanner.nextLine());

		while (option != 4) {
			System.out.println("Enter menu option ");
			System.out.println("1: Add");
			System.out.println("2: Edit");
			System.out.println("3: Delete ");
			System.out.println("4: Exit");
			option = checkDigit();
			if (option == 1) {// need to check next available space if user
								// deleted something

				// id = Integer.parseInt(scanner.nextLine());
				id = products.size() + 1;

				// name = scanner.nextLine();
				name = checkName();

				// price = Double.parseDouble(scanner.nextLine());
				price = checkDouble();
				addProduct(id, name, price, products);

			}

			else if (option == 2) { // edits designated id

				System.out.println("Enter Product ID: ");
				id = checkDigit();

				// name = scanner.nextLine();
				name = checkName();

				price = checkDouble();
				// price = Double.parseDouble(scanner.nextLine());
				// products.set(id, name,price);
				editProduct(id, name, price, products);
			}

			else if (option == 3) {
				System.out.println("Enter Product ID: ");
				id = checkDigit();
				deleteProduct(id, products);
				// id = Integer.parseInt(scanner.nextLine());
			}

			// option = Integer.parseInt(scanner.nextLine());
		}
		System.out.println("goodbye");
	}

}