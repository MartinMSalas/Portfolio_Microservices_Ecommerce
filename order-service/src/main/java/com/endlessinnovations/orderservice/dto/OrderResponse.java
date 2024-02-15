package com.endlessinnovations.orderservice.dto;

import com.endlessinnovations.orderservice.model.OrderLineItems;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private Long id;
    private String orderNumber;
    private List<OrderLineItems> orderLineItemsList;
}
