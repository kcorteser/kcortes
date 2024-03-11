package com.example.kcortes.service;

import com.example.kcortes.dto.DriverRequest;
import com.example.kcortes.model.Driver;


import java.util.List;

public interface DriverService {
    Driver createDriver(DriverRequest driver);
    void deleteDriver(DriverRequest driver);
    List<DriverRequest> getAllDrivers(Long warehouseId, Long truckId);
}
