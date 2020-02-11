package co.edu.icesi.fi.ci.junit5exercise.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import co.edu.icesi.fi.ci.junit5exercise.model.Order;

public class OrderServiceImpl implements OrderService {

	HashMap<Integer, Order > orders = new HashMap<>();
	
	//dummy method
	public String getOrderDescription(int id) {
		Order existingOrder = orders.get(id);
		/*Order existingOrder = new Order();
		existingOrder.setDescription("Order for XYZ in units");*/
		return "Description: " + existingOrder.getDescription();
	}

	//dummy method
	public String getOrderStringCode(int id) {
		Order existingOrder =  orders.get(id); //new Order();
	//	existingOrder.setSecurityCode("XYZ");
		return "Account Code: " + existingOrder.getSecurityCode();
	}
	
	//dummy method
	public Order createOrder(Order order) {
		Order newOrder = null;
		if(order.getDescription() != null && order.getOrderDate() != null && order.getOrderStatus() != null && order.getSecurityCode() != null ) {
			if (order.getSecurityCode().length() == 4) {
				if( order.getOrderStatus().equalsIgnoreCase("INITIATED")|| order.getOrderStatus().equalsIgnoreCase("SHIPPED")|| order.getOrderStatus().equalsIgnoreCase("CANCELED") || order.getOrderStatus().equalsIgnoreCase("IN WAREHOUSE") ) {
					newOrder = order;
					orders.put(newOrder.getOrderId(), newOrder);
				}
			}
		}
		
		/*Order newOrder = new Order();
		newOrder.setOrderId(new Random().nextInt());
		newOrder.setSecurityCode("XYZ");
		newOrder.setOrderStatus("INITIATED");
		newOrder.setOrderDate(new Date());
		orders.put(newOrder.getOrderId(), newOrder);**/
		
		
		return newOrder;
	}
	
	
	public boolean removeOrder(int id) {
		return orders.remove(id, orders.get(id));
	}
	
	public boolean clearOrders() {
		orders.clear();
		return orders.isEmpty();
	}
	
	//dummy method
	public Order getOrder(int id) {
		Order existingOrder =  orders.get(id); 
		
		/*Order newOrder = new Order();
		newOrder.setOrderId(new Random().nextInt());
		newOrder.setSecurityCode("XYZ");
		newOrder.setOrderStatus("COMPLETED");
		newOrder.setOrderDate(new Date());
		newOrder.setDescription("This is the new XYZ order");*/
		return existingOrder;
	}
	
	

}
