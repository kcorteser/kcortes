package com.example.kcortes.mapper;

import com.example.kcortes.dto.WarehouseRequest;
import com.example.kcortes.model.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface WarehouseMapper {

    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastModified", ignore = true)
    Warehouse mapToWarehouse(WarehouseRequest warehouseRequest);
}
