package com.example.kcortes.controller;

import com.example.kcortes.dto.DriverRequest;
import com.example.kcortes.model.Driver;
import com.example.kcortes.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping("")
    public ResponseEntity<Driver> createDriver(@RequestBody DriverRequest driver) {
        Driver createdDriver = driverService.createDriver(driver);
        return new ResponseEntity<>(createdDriver, HttpStatus.CREATED);
    }

    @DeleteMapping()
    public ResponseEntity<Void> removeDriverFromTruck(@RequestBody DriverRequest driver) {
        driverService.deleteDriver(driver);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping()
    public ResponseEntity<List<DriverRequest>> getAllDrivers(
            @RequestParam(required = false) Long warehouseId,
            @RequestParam(required = false) Long truckId) {
        List<DriverRequest> drivers = driverService.getAllDrivers(warehouseId, truckId);
        return ResponseEntity.ok(drivers);
    }
}

