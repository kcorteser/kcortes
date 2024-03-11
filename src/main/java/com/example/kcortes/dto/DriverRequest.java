package com.example.kcortes.dto;


import lombok.Data;

@Data
public class DriverRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String licenseNumber;
    private String licenseType;
    private String experienceLevel;
    private boolean hasCertification;
    private Long truckId;
}