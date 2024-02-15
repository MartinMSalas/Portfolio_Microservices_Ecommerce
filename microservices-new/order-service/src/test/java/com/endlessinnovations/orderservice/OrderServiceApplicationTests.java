package com.endlessinnovations.orderservice;

import com.endlessinnovations.orderservice.model.Order;
import com.endlessinnovations.orderservice.model.OrderLineItems;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceApplicationTests {


	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testCreateOrder() {
		Order order = new Order();
		order.setOrderNumber("12345");

		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setSkuCode("12345");
		orderLineItems.setQuantity(1);
		order.setOrderLineItemsList(Collections.singletonList(orderLineItems));

		ResponseEntity<Order> response = restTemplate.postForEntity("/api/order", order, Order.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		Order createdOrder = response.getBody();

		assertEquals("12345", createdOrder.getOrderNumber());
		assertEquals(1, createdOrder.getOrderLineItemsList().size());
		//assertEquals("Test Product", createdOrder.getOrderLineItemsList().get(0).getProductName());
	}
}
