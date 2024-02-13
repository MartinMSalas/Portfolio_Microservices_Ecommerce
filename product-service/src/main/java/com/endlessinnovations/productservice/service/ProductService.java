package com.endlessinnovations.productservice.service;

import com.endlessinnovations.productservice.dto.ProductRequest;
import com.endlessinnovations.productservice.dto.ProductResponse;
import com.endlessinnovations.productservice.model.Product;
import com.endlessinnovations.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;


    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        Product productSaved = productRepository.save(product);
        log.info("Product " + productSaved.getId() + " created successfully");
        return ProductResponse.builder()
                .id(productSaved.getId())
                .name(productSaved.getName())
                .description(productSaved.getDescription())
                .price(productSaved.getPrice().toString())
                .build();
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponseList = products.stream().map(this::mapToProductResponse).toList();

        return productResponseList;
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice().toString())
                .build();
    }
}
