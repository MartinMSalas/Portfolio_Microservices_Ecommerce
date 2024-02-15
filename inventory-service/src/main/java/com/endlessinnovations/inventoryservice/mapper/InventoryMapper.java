package com.endlessinnovations.inventoryservice.mapper;

import com.endlessinnovations.inventoryservice.dto.InventoryRequest;
import com.endlessinnovations.inventoryservice.dto.InventoryResponse;
import com.endlessinnovations.inventoryservice.model.Inventory;
import org.mapstruct.Mapper;

@Mapper
public interface InventoryMapper {
    Inventory inventoryRequestToInventory(InventoryRequest inventoryRequest);
    InventoryResponse inventoryToInventoryResponse(Inventory inventory);
}
