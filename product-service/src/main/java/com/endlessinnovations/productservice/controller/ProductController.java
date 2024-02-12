package com.endlessinnovations.productservice.controller;

import com.endlessinnovations.productservice.dto.ProductRequest;
import com.endlessinnovations.productservice.dto.ProductResponse;
import com.endlessinnovations.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse response = productService.createProduct(productRequest);
        return new ResponseEntity<>(response);

    }
}
