package co.edu.icesi.fi.ci.junit5exercise.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.icesi.fi.ci.junit5exercise.main.AppConfig;
import co.edu.icesi.fi.ci.junit5exercise.model.Order;
import co.edu.icesi.fi.ci.junit5exercise.service.OrderService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class JUnitSpringTests {
	
	@Autowired
	private OrderService orderService;
	
	/*public JUnitSpringTests(OrderService orderService) {
		this.orderService = orderService;
	}*/
	
	/*@BeforeAll
	public static void  setupAll() {
		System.out.println("----->  INICIO DE PRUEBAS <-----");
	}*/
	
	
	@BeforeAll
	public static void setUp() {
		System.out.println("-----> SETUP <-----");
	}
	
	@BeforeEach
	public void addOrder() {
		Order order = new Order();
		order.setDescription("Description: 1234");
		order.setSecurityCode("0000");
		order.setOrderId(0);
		order.setOrderDate(new Date());
		order.setOrderStatus("INITIATED");
		orderService.createOrder(order);
		System.out.println();
	}

	@Test
	public void testSampleServiceGetAccountDescription() {
		assertTrue(orderService.getOrderDescription(0).startsWith("Description"));
		// Check if the return description has a 'Description:' string.
	}

	@Test
	public void testSampleServiceGetAccountCode() {
		// Check if the return description has a 'Code:' string.
		assertTrue(orderService.getOrderStringCode(0).startsWith("Account Code:"));
	}
	
	@Test
	public void testAddOrder() {
		Order order = orderService.getOrder(0);
		assertAll("group", ()-> assertNotNull(order), ()-> assertNotNull(order.getDescription()), ()-> assertNotNull(order.getSecurityCode()));
		/*Order order = new Order();
		order.setOrderId(0);
		order.setOrderDate(new Date());
		order.setDescription("Description");
		order.setSecurityCode("Security Code");
		order.setOrderStatus("INITIATED");
		orderService.createOrder(order);
		Order foundOrder = orderService.getOrder(0);
		assertAll("properties", () -> {
			String description = foundOrder.getDescription();
            assertNotNull(description);
		}, ()->{
            String securityCode = foundOrder.getSecurityCode();
            assertNotNull(securityCode);
		}
		);*/
	}
	
	@Test
	public void testFindOrder() {
		Order foundOrder = orderService.getOrder(0);
		assertAll("properties", () -> {
			String description = foundOrder.getDescription();
            assertNotNull(description);
		}, ()->{
            String securityCode = foundOrder.getSecurityCode();
            assertNotNull(securityCode);
		}, ()->{
            String status = foundOrder.getOrderStatus();
            assertNotNull(status);
		}, ()->{
			    int id = foundOrder.getOrderId();
			    assertNotNull(id);
			}
		);
	}
	
	@Test
	public void testRemoveOrder() {
		assertTrue(orderService.removeOrder(0));
	}
	
	@Test
	public void testRemoveAllOrders() {
		assertTrue(orderService.clearOrders());
	
	}
	
	@AfterEach
	public void clearOrders() {
		orderService.clearOrders();
	}
	@AfterAll
	public static void afterTest() {
		System.out.println("-----> DESTROY <-----");
	}
	
	/*@AfterAll
	public static void downAll() {
		System.out.println("-----> PRUEBAS FINALIZADAS <-----");
	}*/
}
