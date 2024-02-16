package com.endlessinnovations.orderservice;

import com.endlessinnovations.orderservice.dto.OrderRequest;
import com.endlessinnovations.orderservice.dto.OrderResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testCreateOrder() {
		OrderRequest orderRequest = new OrderRequest();

		orderRequest.setOrderNumber("12345");


		ResponseEntity<OrderResponse> response = restTemplate.postForEntity("/api/order", orderRequest, OrderResponse.class);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());

		OrderResponse createdOrder = response.getBody();

		assertEquals("12345", createdOrder.getOrderNumber());

	}
}