package com.endlessinnovations.orderservice.controller;

import com.endlessinnovations.orderservice.dto.OrderRequest;
import com.endlessinnovations.orderservice.dto.OrderResponse;
import com.endlessinnovations.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {


    private  final OrderService orderService;


    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse response = orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
