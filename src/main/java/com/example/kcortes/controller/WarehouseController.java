package com.example.kcortes.controller;

import com.example.kcortes.dto.WarehouseRequest;
import com.example.kcortes.model.Warehouse;
import com.example.kcortes.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping
    public ResponseEntity<Warehouse> createWarehouse(@RequestBody WarehouseRequest warehouse) {
        Warehouse createdWarehouse = warehouseService.createWarehouse(warehouse);
        return new ResponseEntity<>(createdWarehouse, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Warehouse> updateWarehouse(@RequestBody WarehouseRequest warehouse) {
        Warehouse updatedWarehouse = warehouseService.updateWarehouse(warehouse);
        return new ResponseEntity<>(updatedWarehouse, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteWarehouse(@RequestBody WarehouseRequest warehouse) {
        warehouseService.deleteWarehouse(warehouse);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Warehouse>> getAllWarehouse() {
        List<Warehouse> warehousesList = warehouseService.getAllWarehouse();
        return ResponseEntity.ok(warehousesList);
    }

    @GetMapping("/{warehouseId}") // Especifica el nombre del parámetro en la URL
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable Long warehouseId) {
        Warehouse warehouse = warehouseService.getWarehouseById(warehouseId);
        return ResponseEntity.ok(warehouse);
    }



}
