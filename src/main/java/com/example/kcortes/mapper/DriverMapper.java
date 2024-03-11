package com.example.kcortes.mapper;
import com.example.kcortes.dto.DriverRequest;
import com.example.kcortes.model.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface DriverMapper {
    DriverMapper INSTANCE = Mappers.getMapper(DriverMapper.class);

    @Mapping(target = "truckId", source = "truck.id")
    DriverRequest toDTO(Driver driver);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "truck", ignore = true)
    Driver mapToDriver(DriverRequest driverRequest);
}