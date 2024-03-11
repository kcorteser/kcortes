package com.example.kcortes.service;

import com.example.kcortes.dto.TruckRequest;
import com.example.kcortes.model.Truck;

import java.util.List;

public interface TruckService {
    Truck createTruck( TruckRequest truck);
    void deleteTruck(TruckRequest truck);
    Truck getTruckById(Long truckId);
    List<Truck> getAllTruck();
}
