package co.edu.icesi.fi.ci.junit5exercise.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import co.edu.icesi.fi.ci.junit5exercise.model.Order;
import co.edu.icesi.fi.ci.junit5exercise.service.OrderService;

public class JUnitSpringTests {

	private OrderService orderService;
	
	public JUnitSpringTests(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@BeforeAll
	public static void  setupAll() {
		System.out.println("----->  INICIO DE PRUEBAS <-----");
	}
	
	public static void setUp() {
		System.out.println("-----> SETUP <-----");
	}

	@Test
	public void testSampleServiceGetAccountDescription() {
		assertTrue(orderService.getOrderDescription(0).startsWith("Description"));
		// Check if the return description has a 'Description:' string.
	}

	@Test
	public void testSampleServiceGetAccountCode() {
		// Check if the return description has a 'Code:' string.
		assertTrue(orderService.getOrderDescription(0).startsWith("Account Code:"));
	}
	
	@Test
	public void testAddOrder() {
		Order order = new Order();
		order.setOrderId(0);
		order.setOrderDate(new Date());
		order.setDescription("Description");
		order.setSecurityCode("Security Code");
		orderService.createOrder(order);
		Order foundOrder = orderService.getOrder(0);
		assertAll("properties", () -> {
			String description = foundOrder.getDescription();
            assertNotNull(description);
		}, ()->{
            String securityCode = foundOrder.getSecurityCode();
            assertNotNull(securityCode);
		}
		);
	}
	
	@Test
	public void testNotNullAtributtesOrders() {
		
	}

	public static void afterTest() {
		System.out.println("-----> DESTROY <-----");
	}
	
	@AfterAll
	public static void downAll() {
		System.out.println("-----> PRUEBAS FINALIZADAS <-----");
	}
}
