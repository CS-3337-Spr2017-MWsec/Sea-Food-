package vendor;

import java.util.*;
import vendor.Vendor;

public class Test {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int option=0;
		int id;
		String name;
		Double price;

		ArrayList<Vendor> products = new ArrayList<Vendor>();
		// products.add(new Product (1, "red lobster", 20.00));

		Vendor newProduct = new Vendor(1234, "lobster", 20.00);
		products.add(newProduct);
		
		while (option != 4) {

		System.out.println("Enter menu option ");
		System.out.println("1: Add");
		System.out.println("2: Edit");
		System.out.println("3: Delete ");
		System.out.println("4: Exit");

		// option = Integer.parseInt(scanner.nextLine());
		option = Vendor.checkDigit();
		
			if (option == 1) {

				// id = Integer.parseInt(scanner.nextLine());
				id = products.size() + 1;
			

				// name = scanner.nextLine();
				name = Vendor.checkName();

				// price = Double.parseDouble(scanner.nextLine());
				price = Vendor.checkDouble();
				Vendor.addProduct(id, name, price, products);

			}

			else if (option == 2) { // edits designated id

		
				System.out.println("Enter Product ID: ");
				id = Vendor.checkDigit();
			
				// name = scanner.nextLine();
				name = Vendor.checkName();

				price = Vendor.checkDouble();
				// price = Double.parseDouble(scanner.nextLine());
				// products.set(id, name,price);
				Vendor.editProduct(id, name, price, products);
			}

			else if (option == 3) {
				System.out.println("Enter Product ID: ");
				id = Vendor.checkDigit();
				Vendor.deleteProduct(id,products);
					// id = Integer.parseInt(scanner.nextLine());
			}
			
		}
		System.out.println("goodbye");
	}

}
