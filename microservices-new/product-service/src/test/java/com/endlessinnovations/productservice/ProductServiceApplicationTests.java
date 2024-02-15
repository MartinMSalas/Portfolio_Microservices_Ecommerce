package com.endlessinnovations.productservice;

import com.endlessinnovations.productservice.dto.ProductRequest;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.endlessinnovations.productservice.dto.ProductResponse;
import com.endlessinnovations.productservice.repository.ProductRepository;
import com.mongodb.assertions.Assertions;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ProductRepository productRepository;
/*
	@Autowired
	private ObjectMapper objectMapper;
*/
	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	void shouldCreateProduct() throws Exception {
		ProductRequest productRequest = getProductRequest();

		//String productRequestString = objectMapper.writeValueAsString(productRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
				.contentType("application/json")
				//.content(productRequestString))
				.content("{\"name\":\"Product 1\",\"description\":\"Product 1 description\",\"price\":100}"))
				.andExpect(MockMvcResultMatchers.status().isCreated());

		Assertions.assertTrue(productRepository.findAll().size() == 1);
	}

	private ProductRequest getProductRequest() {
		return ProductRequest.builder()
				.name("Product 1")
				.description("Product 1 description")
				.price(BigDecimal.valueOf(100))
				.build();

	}
	@Test
	public void test_return_empty_list() throws Exception {
		// Arrange
		List<ProductResponse> expectedResponse = new ArrayList<>();

		//Mockito.when(productService.getAllProducts()).thenReturn(expectedResponse);


		// Act
		mockMvc.perform(MockMvcRequestBuilders.get("/api/product"))
				.andExpect(MockMvcResultMatchers.status().isOk());
				//.andExpect(MockMvcResultMatchers.content().json("[]"));

		// Assert
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//		assertEquals(expectedResponse, response.getBody());
	}
}
