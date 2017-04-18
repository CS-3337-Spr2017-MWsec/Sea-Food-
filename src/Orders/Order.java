package Orders;
import java.util.ArrayList;
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
			System.out.println(order.get(i).getOrderId());
			
			System.out.println(order.get(i).getCustomerID());
		}
	}
		public static void edit(){
		}
		
		public static void delete(int orderID, ArrayList<Order> delete){
			
	}

}
