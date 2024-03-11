package com.example.kcortes.service.impl;

import com.example.kcortes.dto.TruckRequest;
import com.example.kcortes.event.TruckDriverEvent;
import com.example.kcortes.exception.WarehouseNotFoundException;
import com.example.kcortes.mapper.TruckMapper;
import com.example.kcortes.model.Truck;
import com.example.kcortes.model.Warehouse;
import com.example.kcortes.repository.TruckRepository;
import com.example.kcortes.service.TruckService;
import com.example.kcortes.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TruckServiceImpl implements TruckService {

    private final TruckRepository truckRepository;
    private final WarehouseService warehouseService;
    private final TruckMapper truckMapper;
    private final ApplicationEventPublisher eventPublisher;
    @Autowired
    public TruckServiceImpl(TruckRepository truckRepository, WarehouseService warehouseService, TruckMapper truckMapper,
    ApplicationEventPublisher eventPublisher) {
        this.truckRepository = truckRepository;
        this.warehouseService = warehouseService;
        this.truckMapper = truckMapper;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public Truck createTruck(TruckRequest truckRequest) {
        Warehouse warehouse = warehouseService.getWarehouseById(truckRequest.getWarehouseId());
        if (warehouse == null) {
            throw new WarehouseNotFoundException("No se encontró el almacén con el ID proporcionado: " + truckRequest.getWarehouseId());
        }
        Truck truck = truckMapper.mapToTruck(truckRequest);
        truck.setWarehouse(warehouse);
        Truck savedTruck = truckRepository.save(truck);
//        eventPublisher.publishEvent(new TruckDriverEvent(this, savedTruck, "Alta"));
        return savedTruck;

    }

    @Transactional
    public void deleteTruck(TruckRequest truck){

        Truck truckDelete = truckRepository.findById(truck.getId())
                .orElseThrow(() -> new EntityNotFoundException("Truck not found with id: " + truck.getId()));

        truckRepository.delete(truckDelete);
//        eventPublisher.publishEvent(new TruckDriverEvent(this, truckDelete, "Baja"));
    }

    public Truck getTruckById(Long truckId) {
        Optional<Truck> truckOptional = truckRepository.findById(truckId);
        if (!truckOptional.isPresent()) {
            throw new EntityNotFoundException("Truck not found with id: " + truckId);
        }
        return truckOptional.get();
    }

    @Override
    public List<Truck> getAllTruck() {
        return truckRepository.findAll();
    }


}
