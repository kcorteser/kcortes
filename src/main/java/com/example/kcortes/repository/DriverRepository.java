package com.example.kcortes.repository;

import com.example.kcortes.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    @Query("SELECT d FROM Driver d JOIN d.truck t WHERE t.warehouse.id = ?1")
    List<Driver> findByWarehouseId(Long warehouseId);

    @Query("SELECT d FROM Driver d WHERE d.truck.id = ?1")
    List<Driver> findByTruckId(Long truckId);

    @Query("SELECT d FROM Driver d JOIN d.truck t WHERE t.warehouse.id = ?1 AND t.id = ?2")
    List<Driver> findByWarehouseIdAndTruckId(Long warehouseId, Long truckId);

}

