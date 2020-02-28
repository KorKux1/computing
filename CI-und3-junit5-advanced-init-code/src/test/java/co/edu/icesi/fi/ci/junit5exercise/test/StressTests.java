package co.edu.icesi.fi.ci.junit5exercise.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.icesi.fi.ci.junit5exercise.Junit5AdvancedApplication;
import co.edu.icesi.fi.ci.junit5exercise.model.Order;
import co.edu.icesi.fi.ci.junit5exercise.service.OrderService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Junit5AdvancedApplication.class)
@SpringBootTest
public class StressTests {

	@Autowired
	private OrderService orderService;

	public StressTests(OrderService orderService) {
		this.orderService = orderService;
	}

	@BeforeAll
	public static void setUp() {
		System.out.println("-----> SETUP <-----");
	}

	@Nested
	@DisplayName("Creation and Update Tets")
	class CreationTests{
		@Test
		@BeforeEach
		@DisplayName("Create a new order")
		public void testSampleServiceCreateNewOrder() {
			Order newOrder = new Order();
			newOrder.setSecurityCode("XYZ");
			newOrder.setDescription("Description");
			newOrder.setOrderId(1);
			if (newOrder != null) {
				assertTrue(orderService.createOrder(newOrder) instanceof Order);
				assertNotNull("Security isn't null", newOrder.getSecurityCode());
				assertNotNull("Description isn't not null", newOrder.getDescription());
			}
			assertNotNull(newOrder, "New Order is not null");
		}
	}

	@Nested
	@DisplayName("Query Tests")
	class QueryTests{ 
		
		@Test
		@RepeatedTest(100)
		@DisplayName("check if the return description has a Description")
		public void testSampleServiceGetAccountDescription() {
			// Check if the return description has a 'Description:' string.
			assertTrue(orderService.getOrderDescription(1).contains("Description"));
		}
		
		@Test
		@RepeatedTest(100)
		@DisplayName("check if the return description has a Code")
		public void testSampleServiceGetAccountCode() {
			// Check if the return description has a 'Code:' string.
			assertTrue(orderService.getOrderStringCode(1).contains("XYZ"));
		}
		
		@Test
		@DisplayName("Get a Order")
		public void testSampleServiceGetOrder() {

			Order existingOrder = orderService.getOrder(1);

			if (existingOrder != null) {
				assertTrue(orderService.getOrder(1) instanceof Order);
				assertNotNull("Security isn't null", existingOrder.getSecurityCode());
				assertNotNull("Description isn't null", existingOrder.getDescription());
			}
			assertNotNull(existingOrder, "Object is not null");
		}
	}
	
	@AfterAll
	public static void afterTest() {
		System.out.println("-----> DESTROY <-----");
	}
}
