package com.endlessinnovations.inventoryservice.service;

import com.endlessinnovations.inventoryservice.dto.InventoryResponse;
import com.endlessinnovations.inventoryservice.mapper.InventoryMapper;
import com.endlessinnovations.inventoryservice.model.Inventory;
import com.endlessinnovations.inventoryservice.repository.InventoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    private final InventoryMapper inventoryMapper;
    @Override
    public boolean isInStock(String skuCode) {
        if (skuCode == null || skuCode.isEmpty()) {
            throw new IllegalArgumentException("SKU code cannot be null or empty");
        }

        return inventoryRepository.findBySkuCode(skuCode).isPresent();


    }

    @Override
    public List<InventoryResponse> getAllInventory() {
        List<Inventory> inventoryList = inventoryRepository.findAll();
        return inventoryList.stream()
                .map(inventoryMapper::inventoryToInventoryResponse )
                .toList();

    }
}
