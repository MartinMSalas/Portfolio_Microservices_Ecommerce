package com.endlessinnovations.inventoryservice.service;

import com.endlessinnovations.inventoryservice.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {
    boolean isInStock(String skuCode);
    List<InventoryResponse> getAllInventory();
}
