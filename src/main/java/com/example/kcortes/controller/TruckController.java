package com.example.kcortes.controller;

import com.example.kcortes.dto.TruckRequest;
import com.example.kcortes.model.Truck;
import com.example.kcortes.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trucks")
public class TruckController {


    @Autowired
    private TruckService truckService;

    @GetMapping()
    public ResponseEntity<List<Truck>> getAllTruck() {
        List<Truck>  trucks = truckService.getAllTruck();
        return ResponseEntity.ok(trucks);
    }

    @PostMapping()
    public ResponseEntity<Truck> createTruck(@RequestBody TruckRequest truck) {
        Truck createdTruck = truckService.createTruck(truck);
        return new ResponseEntity<>(createdTruck, HttpStatus.CREATED);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteTruck(@RequestBody TruckRequest truck) {
        truckService.deleteTruck(truck);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
