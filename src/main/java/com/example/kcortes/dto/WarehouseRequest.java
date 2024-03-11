package com.example.kcortes.dto;

import lombok.Data;

@Data
public class WarehouseRequest {

    private Long id;
    private String name;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String phoneNumber;
    private String emailAddress;
    private Double capacity;
    private String storageType;
    private String securityLevel;
    private String operatingHours;
    private String status;
}
