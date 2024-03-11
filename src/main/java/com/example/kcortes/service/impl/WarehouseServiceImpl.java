package com.example.kcortes.service.impl;

import com.example.kcortes.dto.WarehouseRequest;
import com.example.kcortes.mapper.WarehouseMapper;
import com.example.kcortes.model.Warehouse;
import com.example.kcortes.repository.WarehouseRepository;
import com.example.kcortes.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseMapper warehouseMapper;

    @Autowired
    public WarehouseServiceImpl(WarehouseRepository warehouseRepository, WarehouseMapper warehouseMapper) {
        this.warehouseRepository = warehouseRepository;
        this.warehouseMapper = warehouseMapper;
    }

    public Warehouse createWarehouse(WarehouseRequest warehouseRequest) {
        Warehouse warehouse = warehouseMapper.mapToWarehouse(warehouseRequest);
        warehouse.setCreationDate(LocalDateTime.now());
        warehouse.setLastModified(LocalDateTime.now());
        return warehouseRepository.save(warehouse);
    }

    public Warehouse getWarehouseById(Long warehouseId) {
        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(warehouseId);
        if (!warehouseOptional.isPresent()) {
            throw new EntityNotFoundException("Warehouse not found with id: " + warehouseId);
        }
        return warehouseOptional.get();
    }

    @Override
    public List<Warehouse> getAllWarehouse() {
        return warehouseRepository.findAll();
    }

    @Transactional
    public Warehouse updateWarehouse(WarehouseRequest warehouse) {
        Warehouse existingWarehouse = warehouseRepository.findById(warehouse.getId())
                .orElseThrow(() -> new EntityNotFoundException("Warehouse not found with id: " + warehouse.getId()));
        existingWarehouse.setName(warehouse.getName());
        existingWarehouse.setAddress(warehouse.getAddress());
        existingWarehouse.setCity(warehouse.getCity());
        existingWarehouse.setCountry(warehouse.getCountry());
        existingWarehouse.setPostalCode(warehouse.getPostalCode());
        existingWarehouse.setPhoneNumber(warehouse.getPhoneNumber());
        existingWarehouse.setEmailAddress(warehouse.getEmailAddress());
        existingWarehouse.setCapacity(warehouse.getCapacity());
        existingWarehouse.setStorageType(warehouse.getStorageType());
        existingWarehouse.setSecurityLevel(warehouse.getSecurityLevel());
        existingWarehouse.setOperatingHours(warehouse.getOperatingHours());
        existingWarehouse.setStatus(warehouse.getStatus());
        return warehouseRepository.save(existingWarehouse);
    }


    @Transactional
    public void deleteWarehouse(WarehouseRequest warehouse) {
        warehouseRepository.deleteById(warehouse.getId());
    }


}
