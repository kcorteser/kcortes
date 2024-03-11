package com.example.kcortes.service;

import com.example.kcortes.dto.WarehouseRequest;
import com.example.kcortes.model.Warehouse;

import java.util.List;


public interface WarehouseService {
    Warehouse createWarehouse(WarehouseRequest warehouse);
    Warehouse updateWarehouse(WarehouseRequest warehouse);
    void deleteWarehouse(WarehouseRequest warehouse);
    Warehouse getWarehouseById(Long warehouseId);

    List<Warehouse> getAllWarehouse();
}
