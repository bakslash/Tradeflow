package com.demo.inventory_service.serviceImpl;

import com.demo.inventory_service.repository.InventoryRepository;
import com.demo.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public boolean checkInventory(String skuCode) {
        log.info("🔍 Checking inventory for SKU: {}", skuCode);

        boolean inStock = inventoryRepository.findBySkuCode(skuCode).isPresent();

        if (inStock) {
            log.info("✅ SKU '{}' found in inventory.", skuCode);
        } else {
            log.warn("❌ SKU '{}' NOT found in inventory.", skuCode);
        }

        return inStock;
    }
}
