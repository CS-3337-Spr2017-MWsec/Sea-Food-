package Orders;

import java.util.ArrayList;
import java.util.Scanner;

import Orders.Order;
import vendor.Vendor;

public class OrderTest {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int option=0;
		int orderId = 0;
		ArrayList<Order> orderList = new ArrayList<Order>();

		 
		Order order = new Order(123, 1000);
		Order order2 = new Order(456,2000);
		orderList.add(order);
		orderList.add(order2);
		while (option != 4) {

			System.out.println("\nEnter menu option ");
			System.out.println("1: Veiw All");
			System.out.println("2: Edit");
			System.out.println("3: Delete ");
			System.out.println("4: Exit");
			
			option = Order.checkDigit();
			
			if (option == 1) {

				
				Order.veiwAll(orderList);

			}

			else if (option == 2) { 

		      Order.edit();
				
			}

			else if (option == 3) {
				
				System.out.println("Enter Order ID: ");
				orderId = Order.checkDigit();
				Order.delete(orderId,orderList);
		}
		
	}
		System.out.println("Everything is up-to-date");
	}
	
	

}
