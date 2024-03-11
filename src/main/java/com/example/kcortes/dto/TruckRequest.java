package com.example.kcortes.dto;

import lombok.Data;

@Data
public class TruckRequest {
    private Long id;
    private String brand;
    private String model;
    private String registrationNumber;
    private Double maxLoadCapacity;
    private String chassisNumber;
    private String engineType;
    private Double engineDisplacement;
    private Integer horsepower;
    private Integer year;
    private String fuelType;
    private Long warehouseId; // ID del almacén al que está asignado el camión
}
