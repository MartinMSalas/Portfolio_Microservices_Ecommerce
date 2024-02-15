package com.endlessinnovations.inventoryservice.dto;

import lombok.Data;

@Data
public class InventoryResponse {
    private Long id;
    private String skuCode;
    private Integer quantity;
}
