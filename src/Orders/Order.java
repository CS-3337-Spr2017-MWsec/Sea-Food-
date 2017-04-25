package Orders;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



public class Order {

	
	int orderId;
	int customerID;
	
	
	
	public Order(int orderId, int customerID) {
		
		this.orderId = orderId;
		this.customerID = customerID;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}


	public static void veiwAll( ArrayList<Order> order){
		for (int i=0; i< order.size();i++){
			System.out.print(order.get(i).getOrderId() +" ");
			
			System.out.println(order.get(i).getCustomerID());
		}
	}
		public static void edit(){
		}
		
		public static void delete(int orderId, ArrayList<Order> orderList){
			Iterator<Order> it = orderList.iterator();
            while(it.hasNext())
            {
                Order order = it.next();
                if(order.getOrderId()==orderId)
                {
                    it.remove();
                    System.out.println("Successfully Deleted");
                }
            }
            System.out.println("OrderId not found!!! Please enter the right Order Id");
				
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

}
