package swfinal.sw.mapper;

import org.mapstruct.Mapper;
import swfinal.sw.dto.RestaurantDto;
import swfinal.sw.entity.RestaurantEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    RestaurantDto toDto(RestaurantEntity restaurantEntity);

    RestaurantEntity toEntity(RestaurantDto restaurantDto);

    List<RestaurantDto> toDtoList(List<RestaurantEntity> restaurantEntityList);
}