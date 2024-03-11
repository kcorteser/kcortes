package com.example.kcortes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    @JsonBackReference
    private Warehouse warehouse;

    @OneToMany(mappedBy = "truck")
    @JsonManagedReference
    private List<Driver> drivers;

}

