package com.demo.inventory_service.controller;

import com.demo.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("skuCode") String skuCode) {
        log.info("📦 Received inventory check request for SKU: {}", skuCode);
        boolean result = inventoryService.checkInventory(skuCode);
        log.info("📊 Inventory check result for '{}': {}", skuCode, result);
        return result;
    }
}
