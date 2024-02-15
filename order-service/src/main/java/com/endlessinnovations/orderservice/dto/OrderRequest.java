package com.endlessinnovations.orderservice.dto;

import com.endlessinnovations.orderservice.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private String orderNumber;
    private List<OrderLineItemsDTO> orderLineItemsDTOList;

}
