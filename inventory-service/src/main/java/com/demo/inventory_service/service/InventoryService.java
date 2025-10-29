package com.demo.inventory_service.service;

import com.demo.inventory_service.model.Inventory;

import java.util.Optional;

public interface InventoryService {
    boolean checkInventory(String skuCode);

}
