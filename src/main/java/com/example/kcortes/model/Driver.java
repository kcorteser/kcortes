package com.example.kcortes.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne
    @JoinColumn(name = "truck_id")
    @JsonBackReference
    private Truck truck;


}