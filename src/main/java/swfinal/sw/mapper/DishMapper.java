package swfinal.sw.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import swfinal.sw.dto.DishDto;
import swfinal.sw.entity.DishEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishMapper {

    @Mapping(source = "restaurant.id", target = "restaurantId")
    DishDto toDto(DishEntity dishEntity);

    @Mapping(target = "restaurant", ignore = true)
    DishEntity toEntity(DishDto dishDto);

    List<DishDto> toDtoList(List<DishEntity> dishEntityList);
}