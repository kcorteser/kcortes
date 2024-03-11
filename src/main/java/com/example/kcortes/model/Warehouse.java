package com.example.kcortes.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "last_modified")
    private LocalDateTime lastModified;


}
