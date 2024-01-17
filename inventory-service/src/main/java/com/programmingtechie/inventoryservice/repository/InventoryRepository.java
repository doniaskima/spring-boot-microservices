package com.programmingtechie.inventoryservice.repository;

import com.programmingtechie.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
//This Java code defines an interface `InventoryRepository` that extends `JpaRepository`
// and declares a method to retrieve a list
// of `Inventory` objects based on a list of SKU codes.
