package com.example.kcortes.mapper;

import com.example.kcortes.dto.TruckRequest;
import com.example.kcortes.model.Truck;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface TruckMapper {
    TruckMapper INSTANCE = Mappers.getMapper(TruckMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "warehouse", ignore = true)
    Truck mapToTruck(TruckRequest truckRequest);
}
