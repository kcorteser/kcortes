package com.example.kcortes.service.impl;

import com.example.kcortes.dto.DriverRequest;
import com.example.kcortes.event.TruckDriverEvent;
import com.example.kcortes.exception.TruckNotFoundException;
import com.example.kcortes.mapper.DriverMapper;
import com.example.kcortes.model.Driver;
import com.example.kcortes.model.Truck;
import com.example.kcortes.repository.DriverRepository;
import com.example.kcortes.service.DriverService;
import com.example.kcortes.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;
    private final TruckService truckService;
    private final DriverMapper driverMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository, TruckService truckService, DriverMapper driverMapper,
                             ApplicationEventPublisher eventPublisher) {
        this.driverRepository = driverRepository;
        this.truckService = truckService;
        this.driverMapper = driverMapper;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public Driver createDriver(DriverRequest driverRequest) {
        Truck truck = truckService.getTruckById(driverRequest.getTruckId());
        if (truck == null) {
            throw new TruckNotFoundException("No se encontró el camión con el ID proporcionado: " + driverRequest.getTruckId());
        }
        Driver driver = driverMapper.mapToDriver(driverRequest);
        driver.setTruck(truck);
        Driver savedDriver = driverRepository.save(driver);
//        eventPublisher.publishEvent(new TruckDriverEvent(this, savedDriver, "Alta")); evento de alta
        return savedDriver;

    }

    @Transactional
    public void deleteDriver(DriverRequest driver){

        Driver driverDelete = driverRepository.findById(driver.getId())
                .orElseThrow(() -> new EntityNotFoundException("Driver not found with id: " + driver.getId()));

        driverRepository.delete(driverDelete);
//        eventPublisher.publishEvent(new TruckDriverEvent(this, driverDelete, "Baja")); evento de baja

    }



    @Transactional(readOnly = true)
    public List<DriverRequest> getAllDrivers(Long warehouseId, Long truckId) {
        List<Driver> drivers;

        if (warehouseId != null && truckId != null) {
            drivers = driverRepository.findByWarehouseIdAndTruckId(warehouseId, truckId);
        } else if (warehouseId != null) {
            drivers = driverRepository.findByWarehouseId(warehouseId);
        } else if (truckId != null) {
            drivers = driverRepository.findByTruckId(truckId);
        } else {
            drivers = driverRepository.findAll();
        }
        return drivers.stream().map(driverMapper::toDTO).collect(Collectors.toList());
    }
}
